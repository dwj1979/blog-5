package com.gong.security.service.impl;

import com.gong.security.lib.util.BeanCopyUtil;
import com.gong.security.repository.ArticleRepository;
import com.gong.security.repository.entity.Article;
import com.gong.security.service.IArticleService;
import com.gong.security.util.validator.CommonValidator;
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
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleVO> getArticlesByUserId(String userId) {
        List<Article> articles = articleRepository.findByUserIdAndEnableIsTrueOrderByUpdateTimeDesc(userId);
        return BeanCopyUtil.createOnListCopy(articles, ArticleVO.class);
    }

    @Override
    public Page<ArticleVO> getArticlesByUserIdAndPage(String userId, Pageable pageable) {
        Page<Article> page = articleRepository.findByUserIdAndEnableIsTrue(userId, pageable);
        return page.map(e -> BeanCopyUtil.createOnCopy(e, ArticleVO.class));
    }

    @Override
    public List<ArticleVO> getArticlesAll() {
        List<Article> list = articleRepository.findByEnableIsTrue();
        return BeanCopyUtil.createOnListCopy(list, ArticleVO.class);
    }

    @Override
    public ArticleVO getArticleByArticleId(String articleId) {
        Article article = articleRepository.findByArticleIdAndEnableIsTrue(articleId);
        CommonValidator.getOk(article);
        return BeanCopyUtil.createOnCopy(article, ArticleVO.class);
    }

    @Override
    public Page<ArticleVO> getArticlesAllByPage(Pageable pageable) {
        Page<Article> page = articleRepository.findByEnableIsTrue(pageable);
        return page.map(e -> BeanCopyUtil.createOnCopy(e, ArticleVO.class));
    }

    @Override
    public ArticleVO saveArticle(ArticleVO articleVO) {
        Article article = BeanCopyUtil.createOnCopy(articleVO, Article.class);
        Article result = articleRepository.save(article);
        CommonValidator.saveOk(result);
        return BeanCopyUtil.createOnCopy(result, ArticleVO.class);
    }

    @Override
    public void deleteArticle(ArticleVO articleVO) {
        Article article = BeanCopyUtil.createOnCopy(articleVO, Article.class);
        article.setEnable(false);
        Article result = articleRepository.save(article);
        CommonValidator.delOk(result);
    }


}
