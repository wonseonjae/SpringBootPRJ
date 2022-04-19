package kopo.poly.controller;

import kopo.poly.dto.RedisDTO;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
