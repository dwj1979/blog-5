package com.gong.security.handler.impl;

import com.gong.security.handler.ArticlesHandler;
import com.gong.security.lib.util.BeanCopyUtil;
import com.gong.security.repository.ArticleRepository;
import com.gong.security.repository.entity.Article;
import com.gong.security.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SNOW on 2018.01.25.
 */
@Service
public class ArticlesHandlerImpl implements ArticlesHandler {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleVO> getArticles(Pageable pageable) {
        Page<Article> page = articleRepository.findAll(pageable);
        return BeanCopyUtil.createOnListCopy(page.getContent(),ArticleVO.class);
    }
}
