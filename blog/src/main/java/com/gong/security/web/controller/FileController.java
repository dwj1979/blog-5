package com.gong.security.web.controller;

import com.gong.security.core.service.storage.StorageFileNotFoundException;
import com.gong.security.core.service.storage.StorageService;
import com.gong.security.util.ResultVOUtil;
import com.gong.security.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by SNOW on 2018.01.23.
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public ResultVO listUploadedFiles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> filesNames = storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList());
        return ResultVOUtil.success(filesNames);
    }

    @GetMapping("/**")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(HttpServletRequest request) {
        String fileName = StringUtils.substringAfter(request.getServletPath(),"/file/");
        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity.ok().body(file);
    }

    @PostMapping
    public ResultVO handleFileUpload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = ((MultipartHttpServletRequest) request);
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, List<MultipartFile>> fileEntry : multipartHttpServletRequest.getMultiFileMap().entrySet()) {
            result.put(fileEntry.getKey(), storageService.store(fileEntry.getValue().get(0)));
        }
        return ResultVOUtil.success(result);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
