package com.gong.security.handler;

import com.gong.security.repository.entity.Article;
import com.gong.security.vo.ArticleVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by SNOW on 2018.01.25.
 */
public interface ArticlesHandler {
    List<ArticleVO> getArticles(Pageable pageable);
}
