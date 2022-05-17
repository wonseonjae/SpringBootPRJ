package kopo.poly.persistance.redis.impl;


import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("MyRedisMapper")
public class MyRedisMapper implements IMyRedisMapper {


        public final RedisTemplate<String , Object> redisDB;

        public MyRedisMapper(RedisTemplate<String, Object> redisDB){
            this.redisDB = redisDB;
        }
    @Override
    public int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception {
            log.info(this.getClass().getName()+".saveRedisString Start!");

            int res = 0;

            String saveData = CmmUtil.nvl(pDTO.getTest_text());

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());

            if(!redisDB.hasKey(redisKey)) {
                redisDB.opsForValue().set(redisKey, saveData);

                redisDB.expire(redisKey,2, TimeUnit.DAYS);
                log.info("save Data");

                res = 1;
            }

            log.info(this.getClass().getName()+".saveRedisString End!");

            return res;
    }

    @Override
    public RedisDTO getRedisString(String redisKey) throws Exception {
            log.info(this.getClass().getName()+".getRedisString Start!");

            log.info("String redisKey : " + redisKey);
            RedisDTO rDTO = new RedisDTO();

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());

            if (redisDB.hasKey(redisKey)) {
                String res = (String) redisDB.opsForValue().get(redisKey);

                log.info("res : " + res);

                rDTO.setTest_text(res);
            }

            log.info(this.getClass().getName()+".getRedisString End!");

        return rDTO;
    }

    @Override
    public int saveRedisJson(String redisKey, RedisDTO pDTO) throws Exception {
            log.info(this.getClass().getName()+".saveRedisJson Start!");
            int res = 0;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

            if(!redisDB.hasKey(redisKey)) {

                redisDB.opsForValue().set(redisKey,pDTO);

                redisDB.expire(redisKey,2,TimeUnit.DAYS);

                log.info("save Data");

                res = 1;
            }
            log.info(this.getClass().getName()+ ".saveRedisJson End!");

            return res;
    }

    @Override
    public int saveRedisList(String redisKey, List<RedisDTO> pList) throws Exception {

            log.info(this.getClass().getName()+".saveRedisList start!");

            int res = 0;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());

            for (RedisDTO dto : pList){
               /* //rightPush() => 오름차순으로 정렬하는 함수
                redisDB.opsForList().rightPush(redisKey, CmmUtil.nvl(dto.getTest_text()));*/
                // leftPush() => 내림차순으로 정렬하는 함수
                redisDB.opsForList().leftPush(redisKey, CmmUtil.nvl(dto.getTest_text()));


            }
            redisDB.expire(redisKey,5,TimeUnit.HOURS);

            res = 1;

            log.info(this.getClass().getName()+".saveRedisList End!");
        return res;
    }

    @Override
    public List<String> getRedisList(String redisKey) throws Exception {

            log.info(this.getClass().getName()+".getRedisList start!");

            List<String> rList = null;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());

            if (redisDB.hasKey(redisKey)) {
                rList = (List) redisDB.opsForList().range(redisKey,0,-1);
            }

            log.info(this.getClass().getName()+".getRedisList end!");


            return rList;
    }

    @Override
    public int saveRedisListJson(String redisKey, List<RedisDTO> pList) throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJson start!");

        int res = 0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        for (RedisDTO dto : pList){
            //rightPush() => 오름차순으로 정렬하는 함수
            redisDB.opsForList().rightPush(redisKey, dto);
            /* // leftPush() => 내림차순으로 정렬하는 함수
            redisDB.opsForList().leftPush(redisKey, dto);*/


        }
        redisDB.expire(redisKey,5,TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisListJson End!");
        return res;
    }

    @Override
    public List<RedisDTO> getRedisListJson(String redisKey) throws Exception {
        log.info(this.getClass().getName()+".getRedisListJson start!");

        List<RedisDTO> rList = null;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if (redisDB.hasKey(redisKey)) {
            rList = (List) redisDB.opsForList().range(redisKey,0,-1);
        }

        log.info(this.getClass().getName()+".getRedisListJson end!");

        return rList;
    }

    @Override
    public int saveRedisListJsonRamda(String redisKey, List<RedisDTO> pList) throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJsonRamda start!");

        int res = 0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        pList.forEach(dto -> redisDB.opsForList().rightPush(redisKey, dto));
        redisDB.expire(redisKey,5,TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisListJsonRamda End!");
        return res;
    }

    @Override
    public int saveRedisHash(String redisKey, RedisDTO pDTO) throws Exception {

            int res = 0;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());
            redisDB.opsForHash().put(redisKey, "name", CmmUtil.nvl(pDTO.getName()));
            redisDB.opsForHash().put(redisKey, "email", CmmUtil.nvl(pDTO.getEmail()));
            redisDB.opsForHash().put(redisKey, "addr", CmmUtil.nvl(pDTO.getAddr()));

            redisDB.expire(redisKey, 100, TimeUnit.MINUTES);

            res = 1;

            return res;

    }

    @Override
    public RedisDTO getRedisHash(String redisKey) throws Exception {
            RedisDTO rDTO = new RedisDTO();

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new StringRedisSerializer());

            if (redisDB.hasKey(redisKey)) {
                String name = CmmUtil.nvl((String) redisDB.opsForHash().get(redisKey, "name"));
                String addr = CmmUtil.nvl((String) redisDB.opsForHash().get(redisKey, "addr"));
                String email = CmmUtil.nvl((String) redisDB.opsForHash().get(redisKey, "email"));

                rDTO.setName(name);
                rDTO.setAddr(addr);
                rDTO.setEmail(email);
            }
        return rDTO;
    }

    @Override
    public int saveRedisSet(String redisKey, Set<RedisDTO> pSet) throws Exception{
            int res = 0;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

            pSet.forEach(dto -> redisDB.opsForSet().add(redisKey, dto));

            redisDB.expire(redisKey, 5, TimeUnit.HOURS);

            res =1 ;

            return res;
    }

    @Override
    public Set<RedisDTO> getRedisSet(String redisKey) throws Exception {

        Set<RedisDTO> rSet = null;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if (redisDB.hasKey(redisKey)) {
            rSet = (Set) redisDB.opsForSet().members(redisKey);
        }

        return rSet;
    }

    @Override
    public int saveRedisZSet(String redisKey, List<RedisDTO> pList) throws Exception {
            log.info(this.getClass().getName()+"saveRedisZSet start!");

            int res = 0;
            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));
            int idx = 0;

            for (RedisDTO dto : pList) {
                log.info(dto.getAddr());
                redisDB.opsForZSet().add(redisKey, dto, ++idx);
            }

            redisDB.expire(redisKey,5,TimeUnit.HOURS);

            res = 1;
            log.info(this.getClass().getName()+"saveRedisZSet start!");

            return res;
    }

    @Override
    public Set<RedisDTO> getRedisZSet(String redisKey) throws Exception {

            Set<RedisDTO> rSet = null;

            redisDB.setKeySerializer(new StringRedisSerializer());
            redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

            if (redisDB.hasKey(redisKey)) {
                long cnt = redisDB.opsForZSet().size(redisKey);

                rSet = (Set) redisDB.opsForZSet().range(redisKey,0,cnt);
            }
            return rSet;

    }

    @Override
    public boolean deleteDataJSON(String redisKey) throws Exception {
        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        boolean res = false;

        if (redisDB.hasKey(redisKey)) {
            redisDB.delete(redisKey);

            res = true;
        }
            return res;
    }

}

