package com.gong.security.repository;

import com.gong.security.repository.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SNOW on 2018.01.25.
 */
public interface ArticleRepository extends JpaRepository<Article, String> {
}
