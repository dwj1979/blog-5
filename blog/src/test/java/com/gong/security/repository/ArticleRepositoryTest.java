package com.gong.security.repository;

import com.gong.security.BlogApplication;
import com.gong.security.repository.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by SNOW on 2018.01.25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
//@Transactional
@Slf4j
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findBy() throws Exception {
    }

    @Test
    public void save() throws Exception {
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("Getting Started with Sleek");
            article.setContentMd("### 123123\n" +
                    "# 123\n" +
                    "## 123234\n" +
                    "1.   有序列表\n" +
                    "\n" +
                    "```java\n" +
                    "    Integer getNum(){\n" +
                    "        return 123\n" +
                    "    }\n" +
                    "```");
            article.setContentHtml("<h3>123123</h3>\n" +
                    "<h1>123</h1>\n" +
                    "<h2>123234</h2>\n" +
                    "<ol>\n" +
                    "<li>有序列表</li>\n" +
                    "</ol>\n" +
                    "<pre><div class=\"hljs\"><code class=\"lang-java\">    <span class=\"hljs-function\">Integer <span class=\"hljs-title\">getNum</span><span class=\"hljs-params\">()</span></span>{\n" +
                    "        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-number\">123</span>\n" +
                    "    }\n" +
                    "</code></div></pre>");
            article.setTitleImgUrl("1.jpg");
            Article result = articleRepository.save(article);
            log.debug("" + result);
        }
    }
}