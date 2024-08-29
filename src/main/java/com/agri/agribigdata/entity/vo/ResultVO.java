package com.agri.agribigdata.entity.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public static ResultVO success(){
        return new ResultVO(200,"OK",null);
    }

    public static ResultVO success(Object data){
        return new ResultVO(200,"OK",data);
    }

    public static ResultVO success(String msg, Object data){
        return new ResultVO(200,msg,data);
    }

    public static ResultVO error(Integer code, String msg){return new ResultVO(code,msg,null);}


}