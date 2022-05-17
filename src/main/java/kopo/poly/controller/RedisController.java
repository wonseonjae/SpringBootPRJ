package kopo.poly.controller;

import kopo.poly.dto.RedisDTO;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class RedisController {

    @Resource(name="MyRedisService")
    private IMyRedisService myRedisService;

    @GetMapping(value = "/redis/saveRedisString")
    public String saveRedisString() throws Exception{
        log.info(this.getClass().getName()+".saveRedisString Start!");

        String msg;

        int res = myRedisService.saveRedisString();
        if (res == 1) {
            msg="success";
        }else {
            msg = "fail";
        }
        log.info(this.getClass().getName()+".saveRedisString End!");

        return msg;
    }

    @GetMapping(value = "redis/getRedisString")
    public RedisDTO getRedisString() throws Exception {
        log.info(this.getClass().getName()+".getRedisString Start!");

        RedisDTO rDTO = myRedisService.getRedisString();

        log.info(this.getClass().getName()+".getRedisString Start!");

        return rDTO;
    }

    @GetMapping(value="redis/saveRedisJson")
    public String saveRedisJson() throws Exception {
        log.info(this.getClass().getName()+".saveRedisJson Start!");
        String msg = "";
        int res = myRedisService.saveRedisJson();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        return msg;
    }

    @GetMapping(value="redis/saveRedisList")
    public String saveRedisList() throws Exception {
        log.info(this.getClass().getName()+".saveRedisList Start!");
        String msg = "";
        int res = myRedisService.saveRedisList();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        return msg;
    }

    @GetMapping(value = "redis/getRedisList")
    public List<String> getRedisList() throws Exception {
        log.info(this.getClass().getName()+".getRedisList Start!");

        List<String> rList = myRedisService.getRedisList();

        log.info(this.getClass().getName()+".getRedisList Start!");

        return rList;
    }

    @GetMapping(value="redis/saveRedisListJson")
    public String saveRedisListJson() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJson Start!");
        String msg = "";
        int res = myRedisService.saveRedisListJson();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        return msg;
    }
    @GetMapping(value = "redis/getRedisListJsonRamda")
    public List<RedisDTO> getRedisListJson() throws Exception {
        log.info(this.getClass().getName()+".getRedisListJson Start!");

        List<RedisDTO> rList = myRedisService.getRedisListJson();

        log.info(this.getClass().getName()+".getRedisListJson Start!");

        return rList;
    }

    @GetMapping(value="redis/saveRedisListJsonRamda")
    public String saveRedisListJsonRamda() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJsonRamda Start!");
        String msg = "";
        int res = myRedisService.saveRedisListJsonRamda();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        return msg;
    }

    @GetMapping(value="redis/saveRedisHash")
    public String saveRedisHash() throws Exception{
        String msg = "";
        int res = myRedisService.saveRedisHash();

        if (res == 1) {
            msg = "성공";
        } else {
            msg = "실패";
        }
        return msg;
    }

    @GetMapping(value = "redis/getRedisHash")
    public RedisDTO getRedisHash() throws Exception{
        RedisDTO rDTO = myRedisService.getRedisHash();

        return rDTO;
    }

    @GetMapping(value = "redis/saveRedisSet")
    public String saveRedisSet() throws Exception{
        String msg = "";

        int res = myRedisService.saveRedisSet();

        if (res==1) {
            msg = "성공";
        }else {
            msg = "실패";
        }
        return msg;
    }

    @GetMapping(value = "redis/getRedisSet")
    public Set<RedisDTO> getRedisSet() throws Exception {
        Set<RedisDTO> rSet = myRedisService.getRedisSet();
        return rSet;
    }

    @GetMapping(value = "/redis/saveRedisZSet")
    public String saveRedisZSet() throws Exception{
        String msg = "";

        int res = myRedisService.saveRedisZSet();

        if (res == 1) {
            msg = "성공";
            return msg;

        }else {
            msg = "실패";
            return msg;
        }

    }

    @GetMapping(value = "/redis/getRedisZSet")
    public Set<RedisDTO> getRedisZSet() throws Exception {
        Set<RedisDTO> rSet = myRedisService.getRedisZSet();
        return  rSet;
    }

    @GetMapping(value = "/reis/deleteDataJSON")
    public boolean deleteDataJSON() throws Exception {
        boolean res = myRedisService.deleteDataJSON();

        return res;
    }

}
