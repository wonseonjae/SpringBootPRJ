package kopo.poly.persistance.redis;

import kopo.poly.dto.MelonDTO;

import java.util.List;

public interface IMelonCacheMapper {

    int insertSong(List<MelonDTO> pList, String redisKey) throws Exception;

    boolean getExistKey(String redisKey) throws Exception;

    List<MelonDTO> getSongList(String redisKey) throws Exception;
}
