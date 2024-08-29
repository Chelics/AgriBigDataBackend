package com.agri.agribigdata.exception;


import com.agri.agribigdata.entity.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultVO ex(Exception e){
        log.error("捕获到异常: ",e);
        return ResultVO.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public ResultVO ex(CustomException ce){
        log.error("捕获到异常: ",ce);
        return ResultVO.error(ce.getCode(), ce.getMessage());
    }

}
