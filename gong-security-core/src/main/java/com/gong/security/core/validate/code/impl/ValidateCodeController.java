package com.gong.security.core.validate.code.impl;

import com.gong.security.core.validate.code.ValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by SNOW on 18.1.2.
 */
@Slf4j
@RestController
public class ValidateCodeController {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 根据随机数生成图片
     * 把随机数保存到session
     * 生成的图片写入相应中。
     *
     * @param request
     * @param response
     */
    @GetMapping("/code/{type}")
    public void createCode(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(type + "ValidateCodeProcessor");
        validateCodeProcessor.create(new ServletWebRequest(request, response));
    }

}
