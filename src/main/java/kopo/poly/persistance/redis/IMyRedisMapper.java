package kopo.poly.persistance.redis;

import kopo.poly.dto.RedisDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.cache.CacheProperties;

import java.util.List;
import java.util.Set;


public interface IMyRedisMapper {
    /*
    String타입 저장하기
    @param redisKey Redis저장 키
    @param pDTO 저장할 정보
    @return 저장 성공 여부
    */
    int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception;
    /*
    String타입 호출하기
    @param redisKey Redis저장 키
    @return 저장된 문자열
    */
    RedisDTO getRedisString(String redisKey) throws Exception;
    /*
    String타입 저장하기
    @param redisKey Redis저장 키
    @param pDTO 저장할 정보
    @return 저장 성공 여부
    */
    int saveRedisJson(String redisKey, RedisDTO pDTO) throws Exception;

    int saveRedisList(String redisKey, List<RedisDTO> pList) throws Exception;

    List<String> getRedisList(String redisKey) throws Exception;

    int saveRedisListJson(String redisKey, List<RedisDTO> pList) throws Exception;

    List<RedisDTO> getRedisListJson(String redisKey) throws Exception;

    int saveRedisListJsonRamda(String redisKey, List<RedisDTO> pList) throws Exception;

    int saveRedisHash(String redisKey, RedisDTO pDTO) throws Exception;

    RedisDTO getRedisHash(String redisKey) throws Exception;

    int saveRedisSet(String redisKey, Set<RedisDTO> pSet) throws Exception;

    Set<RedisDTO> getRedisSet(String redisKey) throws Exception;

    int saveRedisZSet(String redisKey, List<RedisDTO> pList) throws Exception;

    Set<RedisDTO> getRedisZSet(String redisKey) throws Exception;

    boolean deleteDataJSON(String redisKey) throws Exception;
}
