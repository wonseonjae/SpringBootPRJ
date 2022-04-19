package kopo.poly.service.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

        String redisKey = "myRedis_String_Json";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("나는 Json구조 텍스트");
        pDTO.setName("원선재");
        pDTO.setAddr("경기도 김포시");
        pDTO.setEmail("bij7750@gmail.com");

        int res = myRedisMapper.saveRedisJson(redisKey, pDTO);

        log.info(this.getClass().getName()+".saveRedisJson End!");
        return res;
    }

}
