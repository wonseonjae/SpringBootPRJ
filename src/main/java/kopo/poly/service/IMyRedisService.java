package kopo.poly.service;

import kopo.poly.dto.RedisDTO;

import java.util.List;
import java.util.Set;

public interface IMyRedisService {

    /*
    String 타입 저장하기
    */
    int saveRedisString() throws Exception;

     /*
    String 타입 호출하기
    */
    RedisDTO getRedisString() throws Exception;

    /*
   Json 타입 저장하기
   */
    int saveRedisJson() throws Exception;

    /*
    List타입 저장하기
    */
    int saveRedisList() throws Exception;

    /*
    List타입 호출하기
    */
    List<String> getRedisList() throws Exception;

    /*
    List타입에 Json타입 저장하기
    */
    int saveRedisListJson() throws Exception;

    /*
    List타입 호출하기
    */
    List<RedisDTO> getRedisListJson() throws Exception;

    /*
   List타입에 Json타입 람다식으로 저장하기
   */
    int saveRedisListJsonRamda() throws Exception;

    int saveRedisHash() throws Exception;

    RedisDTO getRedisHash() throws Exception;

    int saveRedisSet() throws Exception;

    Set<RedisDTO> getRedisSet() throws Exception;

    int saveRedisZSet() throws Exception;

    Set<RedisDTO> getRedisZSet() throws Exception;

    boolean deleteDataJSON() throws Exception;


}
