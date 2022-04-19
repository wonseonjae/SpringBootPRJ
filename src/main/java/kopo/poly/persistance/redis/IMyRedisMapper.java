package kopo.poly.persistance.redis;

import kopo.poly.dto.RedisDTO;
import org.apache.ibatis.annotations.Mapper;


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
}
