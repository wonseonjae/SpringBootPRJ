package kopo.poly.service.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service("MyRedisService")
public class MyRedisService implements IMyRedisService {

    @Resource(name="MyRedisMapper")
    private IMyRedisMapper myRedisMapper;

    @Override
    public int saveRedisString() throws Exception {
        log.info(this.getClass().getName()+".saveRedisString Start!");
        String redisKey = "myRedis_String";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 String타입으로 저장할 일반 문자열");

        int res = myRedisMapper.saveRedisString(redisKey,pDTO);

        log.info(this.getClass().getName()+".savaRedisString End!");
        return res;
    }

    @Override
    public RedisDTO getRedisString() throws Exception {
        log.info(this.getClass().getName()+"getRedisString Start!");

        String redisKey = "myRedis_String";

        RedisDTO rDTO = myRedisMapper.getRedisString(redisKey);

        if (rDTO == null) {
            rDTO = new RedisDTO();
        }

        log.info(this.getClass().getName()+".getRedisString End!");
        return rDTO;
    }

    @Override
    public int saveRedisJson() throws Exception {
        log.info(this.getClass().getName()+".savaRedisJson Start!");

        String redisKey = "myRedis_String_Json2";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("저는 원선재 입니다");
        pDTO.setName("원선재");
        pDTO.setAddr("경기도 김포시");
        pDTO.setEmail("bij7750@gmail.com");

        int res = myRedisMapper.saveRedisJson(redisKey, pDTO);

        log.info(this.getClass().getName()+".saveRedisJson End!");
        return res;
    }

    @Override
    public int saveRedisList() throws Exception {

        log.info(this.getClass().getName()+".saveRedisList start!");

        String redisKey = "myRedis_List2";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i+"번째 데이터입니다.");

            pList.add(pDTO);

        }
        int res = myRedisMapper.saveRedisList(redisKey, pList);

        log.info(this.getClass().getName()+".saveRedisList end!");

        return res;
    }

    @Override
    public List<String> getRedisList() throws Exception {
        log.info(this.getClass().getName()+".getRedisList start!");

        String redisKey="myRedis_List";

        List<String> rList = myRedisMapper.getRedisList(redisKey);

        if (rList==null) {
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName()+".getRedisList end!");

        return rList;
    }

    @Override
    public int saveRedisListJson() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJson start!");

        String redisKey = "myRedis_ListJson2";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i+"번째 데이터입니다.");
            pDTO.setName("원선재["+i+"]");
            pDTO.setAddr("김포");
            pDTO.setEmail("bij7750@gmail.com");

            pList.add(pDTO);

        }
        int res = myRedisMapper.saveRedisListJson(redisKey, pList);

        log.info(this.getClass().getName()+".saveRedisListJson end!");

        return res;
    }

    @Override
    public List<RedisDTO> getRedisListJson() throws Exception {
        log.info(this.getClass().getName()+".getRedisListJson start!");

        String redisKey="myRedis_ListJson2";

        List<RedisDTO> rList = myRedisMapper.getRedisListJson(redisKey);

        if (rList==null) {
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName()+".getRedisListJson end!");

        return rList;
    }

    @Override
    public int saveRedisListJsonRamda() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJsonRamda start!");

        String redisKey = "myRedis_ListJsonRamda";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i+"번째 데이터입니다.");
            pDTO.setName("원선재["+i+"]");
            pDTO.setAddr("김포");
            pDTO.setEmail("bij7750@gmail.com");

            pList.add(pDTO);

        }
        int res = myRedisMapper.saveRedisListJsonRamda(redisKey, pList);

        log.info(this.getClass().getName()+".saveRedisListJsonRamda end!");

        return res;
    }

    @Override
    public int saveRedisHash() throws Exception {

        int res = 0;

        String redisKey = "myRedis_Hash";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setName("원선재");
        pDTO.setEmail("bij7750@gmail.com");
        pDTO.setAddr("경기 김포");

        res = myRedisMapper.saveRedisHash(redisKey, pDTO);
        return res;
    }

    @Override
    public RedisDTO getRedisHash() throws Exception {
        String redisKey = "myRedis_Hash";
        return myRedisMapper.getRedisHash(redisKey);
    }

    @Override
    public int saveRedisSet() throws Exception{
        String redisKey = "myRedis_Set_JSON";

        Set<RedisDTO> pSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i+"번째 데이터 입니다.");
            pDTO.setName("원선재");
            pDTO.setEmail("bij7750@gmail.com");
            pDTO.setAddr("경기 김포");

            pSet.add(pDTO);
            pDTO = null;
        }

        int res = myRedisMapper.saveRedisSet(redisKey, pSet);

        return res;
    }

    @Override
    public Set<RedisDTO> getRedisSet() throws Exception {
        String redisKey = "myRedis_Set_JSON";
        return myRedisMapper.getRedisSet(redisKey);
    }

    @Override
    public int saveRedisZSet() throws Exception{
        log.info(this.getClass().getName()+".saveRedisZSet start!");
        String redisKey = "myRedis_ZSet_JSON";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setAddr("김포");
            pDTO.setName("원선재");
            pDTO.setEmail("bij750@gmail.com");
            pDTO.setTest_text(i+"번째 글입니다");

            pList.add(pDTO);
            pDTO = null;
        }

        int res = myRedisMapper.saveRedisZSet(redisKey, pList);
        log.info(this.getClass().getName()+"saveRedisZSet end!");
        return res;
    }


    @Override
    public Set<RedisDTO> getRedisZSet() throws Exception{
        String redisKey = "myRedis_ZSet_JSON";

        Set<RedisDTO> rSet = myRedisMapper.getRedisZSet(redisKey);
        if (rSet == null) {
            rSet = new HashSet<>();
        }
        return rSet;
    }

    @Override
    public boolean deleteDataJSON() throws Exception {

        String redisKey = "myRedis_ZSet_JSON";

        boolean res = myRedisMapper.deleteDataJSON(redisKey);

        return res;
    }


}
