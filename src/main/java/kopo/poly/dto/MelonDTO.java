package kopo.poly.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Getter
@Setter
public class MelonDTO{

    String collectTime;
    String song;
    String singer;
    int singerCnt;

}
