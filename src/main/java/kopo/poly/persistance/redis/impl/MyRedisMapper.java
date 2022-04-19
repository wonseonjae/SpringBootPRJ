package kopo.poly.persistance.redis.impl;

import ch.qos.logback.core.util.TimeUtil;
import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

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
}

