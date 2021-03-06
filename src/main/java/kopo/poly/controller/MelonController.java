package kopo.poly.controller;


import kopo.poly.dto.MelonDTO;
import kopo.poly.service.IMelonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class MelonController {

    @Resource(name = "MelonService")
    private IMelonService melonService;

    /**
     * 멜론 노래 리스트 저장하기
     */
    @GetMapping(value = "melon/collectMelonSong")
    public String collectMelonRank() throws Exception {

        log.info(this.getClass().getName() + ".collectMelonSong Start!");

        // 수집 결과 출력
        String msg;

        int res = melonService.collectMelonSong();

        if (res == 1) {
            msg = "success";

        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".collectMelonSong End!");

        return msg;
    }

    /**
     * 오늘 수집된 멜론 노래리스트 가져오기
     */
    @GetMapping(value = "melon/getSongList")
    public List<MelonDTO> getSongList() throws Exception {

        log.info(this.getClass().getName() + ".getSongList Start!");

        List<MelonDTO> rList = melonService.getSongList();

        log.info(this.getClass().getName() + ".getSongList End!");

        return rList;
    }

    /**
     * 가수별 수집된 노래의 수 가져오기
     */
    @GetMapping(value = "melon/getSingerSongCnt")
    public List<MelonDTO> getSingerSongCnt()
            throws Exception {

        log.info(this.getClass().getName() + ".getSingerSongCnt Start!");

        List<MelonDTO> rList = melonService.getSingerSongCnt();

        log.info(this.getClass().getName() + ".getSingerSongCnt End!");

        return rList;
    }

    @GetMapping(value = "melon/getSingerSong")
    public List<MelonDTO> getSingerSong() throws Exception {

        log.info(this.getClass().getName() + ".getSingerSong Start!");

        List<MelonDTO> rList = melonService.getSingerSong();

        log.info(this.getClass().getName() + ".getSingerSong End!");

        return rList;
    }

    @GetMapping(value = "melon/collectMelonSongMany")
    public String collectMelonSongMany() throws Exception {

        log.info(this.getClass().getName() + ".collectMelonSong Start!");

        // 수집 결과 출력
        String msg;

        int res = melonService.collectMelonSongMany();

        if (res == 1) {
            msg = "success";

        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".collectMelonSong End!");

        return msg;
    }

    /*
    가수이름이 방탄소년단이면 BTS로 변경하기
    */

    @GetMapping(value = "melon/btsAddName")
    public String btsAddName() throws Exception {
        log.info(this.getClass().getName() + "btsAddName controller start!");

        String msg;

        int res = melonService.updateBTSName();

        if (res ==1 ) {
            msg = "success";

        }else {
            msg = "fail";

        }
        log.info(this.getClass().getName() + ".btsAddName controller end!");

        return msg;
    }

    @GetMapping(value = "melon/btsAddNickName")
    public String btsAddField() throws Exception {
        log.info(this.getClass().getName() + "btsAddField controller start!");

        String msg;

        int res = melonService.updateAddBTSNickname();

        if (res ==1 ) {
            msg = "success";

        }else {
            msg = "fail";

        }
        log.info(this.getClass().getName() + ".btsAddName controller end!");

        return msg;
    }

    @GetMapping(value = "melon/btsAddMember")
    public String btsAddListField() throws Exception {
        log.info(this.getClass().getName() + "btsAddListField controller start!");

        String msg;

        int res = melonService.updateAddBTSMember();

        if (res ==1 ) {
            msg = "success";

        }else {
            msg = "fail";

        }
        log.info(this.getClass().getName() + ".btsAddListField controller end!");

        return msg;
    }

    @GetMapping(value = "melon/deleteSong")
    public String deleteSong() throws Exception{
        log.info(this.getClass().getName() + ".deleteSong controller start!");

        String msg;

        int res = melonService.deleteSong();

        if (res ==1 ) {
            msg = "success";

        }else {
            msg = "fail";

        }
        log.info(this.getClass().getName() + ".deleteSong controller end!");

        return msg;
    }

    @GetMapping(value = "melon/updateManySong")
    public String updateManySong() throws Exception{
        log.info(this.getClass().getName() + ".updateManySong Start!");

        String msg;

        int res = melonService.updateManySong();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".updateManySong End!");

        return msg;

    }
}