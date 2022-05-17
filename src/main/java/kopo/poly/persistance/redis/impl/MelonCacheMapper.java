package kopo.poly.persistance.redis.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import kopo.poly.dto.MelonDTO;
import kopo.poly.persistance.redis.IMelonCacheMapper;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("MelonCacheMapper")
public class MelonCacheMapper implements IMelonCacheMapper {

    public final RedisTemplate<String, Object> redisDB;

    public MelonCacheMapper(RedisTemplate<String, Object> redisDB) {
        this.redisDB = redisDB;
    }

    @Override
    public int insertSong(List<MelonDTO> pList, String colNm) throws Exception {

        log.info(this.getClass().getName() + ".insertSong Start!");

        int res = 0;

        String Key = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(MelonDTO.class));

        pList.forEach(melon -> redisDB.opsForList().leftPush(Key, melon));

        redisDB.expire(Key, 1 , TimeUnit.HOURS);

        res = 1;

        return res;
    }

    @Override
    public boolean getExistKey(String redisKey) throws Exception {

        if (redisDB.hasKey(redisKey)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<MelonDTO> getSongList(String redisKey) throws Exception {

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(MelonDTO.class));

        List<MelonDTO> rList = null;

        if (redisDB.hasKey(redisKey)) {
            rList = (List) redisDB.opsForList().range(redisKey,0,-1);
        }

        return rList;
    }


}
