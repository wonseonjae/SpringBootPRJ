package kopo.poly.service;

import kopo.poly.dto.MelonDTO;

import java.util.List;
import java.util.Map;

public interface IMelonService {

    /**
     * 멜론 노래 리스트 저장하기
     */
    int collectMelonSong() throws Exception;

    /**
     * 오늘 수집된 멜론 노래리스트 가져오기
     */
    List<MelonDTO> getSongList() throws Exception;

    /**
     * 멜론 가수별 노래 수 가져오기
     */
    List<MelonDTO> getSingerSongCnt() throws Exception;

    List<MelonDTO> getSingerSong() throws Exception;

    int collectMelonSongMany() throws Exception;

    /*singer 필드의 값인 방탄소년단을 BTS로 변경하기*/
    int updateBTSName() throws Exception;

    /* nickname 필드를 새로 추가하기*/
    int updateAddBTSNickname() throws Exception;
}