package ru.geekbrains.erpsystem.exeptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception e, Model m, HttpServletRequest request) {
        m.addAttribute("message", e.getMessage());
        m.addAttribute("referer", request.getHeader("referer"));
        logger.error(e.getMessage());
        e.printStackTrace();
        return "error";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e, Model m, HttpServletRequest request) {
        m.addAttribute("message", "Файл слишком велик. Нельзя загрузить больше 1 МБ");
        m.addAttribute("referer", request.getHeader("referer"));
        logger.error(e.getMessage());
        e.printStackTrace();
        return "error";
    }

}
