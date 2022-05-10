package kopo.poly.service.impl;

import kopo.poly.dto.MelonDTO;
import kopo.poly.persistance.mongodb.IMelonMapper;
import kopo.poly.service.IMelonService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service("MelonService")
public class MelonService implements IMelonService {

    @Resource(name = "MelonMapper")
    private IMelonMapper melonMapper; //MongoDB에 저장할 Mapper


    @Override
    public int collectMelonSong() throws Exception{
        log.info(this.getClass().getName() + ".collectMelonRank Start!");

        int res = 0;

        List<MelonDTO> pList = new LinkedList<>();

        String url = "https://www.melon.com/chart/index.htm";

        Document doc = Jsoup.connect(url).get();

        Elements element = doc.select("div.service_list_song");

        for (Element songInfo : element.select("div.wrap_song_info")) {

            String song = CmmUtil.nvl(songInfo.select("div.ellipsis.rank01 a").text()); //노래
            String singer = CmmUtil.nvl(songInfo.select("div.ellipsis.rank02 a").eq(0).text());

            log.info("song :" + song);
            log.info("singer : " + singer);

            if ((song.length() > 0 ) && (singer.length() > 0 )) {
                MelonDTO pDTO = new MelonDTO();
                pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMddhhmmss"));
                pDTO.setSong(song);
                pDTO.setSinger(singer);

                pList.add(pDTO);
            }
        }
        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        res = melonMapper.insertSong(pList, colNm);

        log.info(this.getClass().getName() + ".collectMelonSong End!");

        return res;
    }

    @Override
    public List<MelonDTO> getSongList() throws Exception {
        log.info(this.getClass().getName() + ".getSongList Start!");

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        List<MelonDTO> rList = new LinkedList<>();

        rList = melonMapper.getSongList(colNm);

        if (rList == null) {
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName() + ".getSongList End!");

        return rList;

    }



    @Override
    public List<MelonDTO> getSingerSongCnt() throws Exception {
        log.info(this.getClass().getName() + ".getSingerSongCnt Start!");

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        List<MelonDTO> rList = melonMapper.getSingerSongCnt(colNm);

        if(rList == null) {
            rList = new LinkedList<>();
        }

        log.info(this.getClass().getName() + ".getSingerSongCnt End");

        return rList;
    }

    @Override
    public List<MelonDTO> getSingerSong() throws Exception {
        log.info(this.getClass().getName() + ".getSingerSong Start!");

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");
        String singer = "BTS";

        List<MelonDTO> rList= null;

        if (this.collectMelonSong()==1) {
            rList = melonMapper.getSingerSong(colNm, singer);

            if (rList == null) {
                rList = new LinkedList<>();
            }

        }else {
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName() + ".getSingerSong End!");
        return rList;
    }

    @Override
    public int collectMelonSongMany() throws Exception {
        log.info(this.getClass().getName() + ".collectMelonSongMany Start!");

        int res = 0;

        List<MelonDTO> pList = new LinkedList<>();

        String url = "https://www.melon.com/chart/index.htm";

        Document doc = Jsoup.connect(url).get();

        Elements element = doc.select("div.service_list_song");

        for (Element songInfo : element.select("div.wrap_song_info")) {

            String song = CmmUtil.nvl(songInfo.select("div.ellipsis.rank01 a").text()); //노래
            String singer = CmmUtil.nvl(songInfo.select("div.ellipsis.rank02 a").eq(0).text());

            log.info("song :" + song);
            log.info("singer : " + singer);

            if ((song.length() > 0 ) && (singer.length() > 0 )) {
                MelonDTO pDTO = new MelonDTO();
                pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMddhhmmss"));
                pDTO.setSong(song);
                pDTO.setSinger(singer);

                pList.add(pDTO);
            }
        }
        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        res = melonMapper.insertSong(pList, colNm);

        log.info(this.getClass().getName() + ".collectMelonSongMany End!");

        return res;
    }

    @Override
    public int updateBTSName() throws Exception {

        log.info(this.getClass().getName() + ".updateBTSName start!");

        int res = 0;

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        melonMapper.dropMelonCollection(colNm);

        if (this.collectMelonSong() == 1) {
            String singer = "방탄소년단";

            String updateSinger = "BTS";

            res = melonMapper.updateSong(colNm, singer, updateSinger);
        }
        log.info(this.getClass().getName() + "updateBTSName end!");

        return res;
    }

    @Override
    public int updateAddBTSNickname() throws Exception {
        log.info(this.getClass().getName() + ".updateAddBTSNickname start!");

        int res = 0;

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        melonMapper.dropMelonCollection(colNm);

        if (this.collectMelonSong() == 1) {
            String singer = "방탄소년단";

            String nickname = "BTS";

            res = melonMapper.updateSongAddField(colNm, singer, nickname);
        }
        log.info(this.getClass().getName() + "updateBTSName end!");

        return res;
    }

    @Override
    public int updateAddBTSMember() throws Exception {
        log.info(this.getClass().getName() + ".updateAddBTSMember start!");

        int res = 0;

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        melonMapper.dropMelonCollection(colNm);

        if (this.collectMelonSong() == 1) {
            String singer = "방탄소년단";

            String[] member = {"정국", "뷔", "지민", "슈가", "진", "제이홉", "RM"};

            res = melonMapper.updateSongAddListField(colNm, singer, Arrays.asList(member));
        }
        log.info(this.getClass().getName() + "updateBTSName end!");

        return res;
    }


    @Override
    public int deleteSong() throws Exception {
        log.info(this.getClass().getName() + ".deleteSong start!");

        int res = 0;

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        String singer = "방탄소년단";

            res = melonMapper.deleteSong(colNm, singer);

        log.info(this.getClass().getName() + "deleteSong end!");

        return res;
    }

    @Override
    public int updateManySong() throws Exception {

        log.info(this.getClass().getName() + ".updateManySong start!");

        int res = 0;

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        melonMapper.dropMelonCollection(colNm);

        if (this.collectMelonSong() == 1) {
            String singer = "방탄소년단";
            String updateSinger = "BTS";
            String updateSong = "BTS-SONG";

            res = melonMapper.updateManySong(colNm, singer, updateSinger, updateSong);
        }

        log.info(this.getClass().getName() + ".updateManySong End!");

        return res;
    }


}
