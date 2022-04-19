package kopo.poly.service;

import kopo.poly.dto.RedisDTO;

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
}
