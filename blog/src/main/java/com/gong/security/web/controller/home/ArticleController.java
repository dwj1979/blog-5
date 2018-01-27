package com.gong.security.web.controller.home;

import com.gong.security.repository.entity.Article;
import com.gong.security.util.ResultVOUtil;
import com.gong.security.vo.ArticleVO;
import com.gong.security.vo.ResultVO;
import com.gong.security.handler.ArticlesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SNOW on 2018.01.25.
 */
@RestController
@RequestMapping("/home/article")
public class ArticleController {

    @Autowired
    private ArticlesHandler articlesHandler;

    @GetMapping
    public ResultVO getArticles(@PageableDefault(page = 0,size = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
        List<ArticleVO> list = articlesHandler.getArticles(pageable);
        return ResultVOUtil.success(list);
    }
}
