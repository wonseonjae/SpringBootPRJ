package kopo.poly.persistance.mongodb;

import kopo.poly.dto.MelonDTO;

import java.util.List;
import java.util.Map;

public interface IMelonMapper {

   /* 멜론 노래 리스트 저장하기
    @param pList 저장된정보
    @param colNm 저장한 컬렉션 이름
    @return 저장 결과
    */

    int insertSong(List<MelonDTO> pList, String colNm) throws Exception;

    /*오늘 수집된 멜론 노래리스트 가져오기
    @param colNm 조회할 컬렉션 이름
    @return 노래 리스트
    */
    List<MelonDTO> getSongList(String colNm) throws Exception;

    /*
    가수별 수집된 노래의 수 가져오기
    @param colNm 조회할 컬렉션 이용
    @return 노래리스트
    */

    List<MelonDTO> getSingerSongCnt(String colNm) throws Exception;

    /*가수별 노래 가져오기

    @param colNm 조회할 컬렉션 이름
    @param singer 가수명
    @return 노래 리스트    */

    List<MelonDTO> getSingerSong(String colNm, String singer) throws Exception;

    /*
    멜론 노래 리스트 저장하기(insertMany 쿼리 사용)
    @param pList 저장될 정보
    @param colNm 저장할 컬렉션 이름
    @return 저장 결과
    */


    int insertSongMany(List<MelonDTO> pList, String colNm) throws Exception;

    /*
    컬렉션 삭제하기

    @param colNm 삭제할 컬렉션 이름
    @return 저장 결과
    */
    int dropMelonCollection(String colNm) throws Exception;

    /*
    가수이름 수정하기
    방탄소년단을 BTS로 변경

    @param colNm 저장할 컬렉션 이름
    @param uppdateSinger 수정될 가수 이름
    @param singer 수정할 가수 이름
    @return 저장 결과
    */

    int updateSong(String colNm, String singer, String updateSinger) throws Exception;

    /*
    가수Nickname 필드 추가 및 값 저장하기

    @param colNm 저장할 컬렉션 이름
    @param singer 추가할 가수 이름
    @param nickname 추가할 가수 닉네임
    @return 저장 결과
    */

    int updateSongAddField(String colNm, String singer, String nickname) throws Exception;

    /*
    그룹멤버이름 리스트 추가 및 값 저장하기

    @param colNm 저장할 컬렉션 이름
    @param singer 추가할 가수 이름
    @param member 추가할 그룹멤버 리스트
    @return 저장 결과
    */

    int updateSongAddListField(String colNm, String singer, List<String> member) throws Exception;



}
