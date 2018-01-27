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
            article.setContent("In case you want to add a hero image to the post, apart from changing featured-img in YAML, you also need to add the image file to the project. To do so, just upload an image in .jpg format to _img folder. The name must before the .jpg file extension has to match with featured-img in YAML. Next, run gulp img from command line to generate optimized version of the image and all the thumbnails. You have to restart the jekyll server to see the changes. Sleek uses (Lazy Sizes)[https://github.com/aFarkas/lazysizes] Lazy Loader for loading images. Check the link for more info. Lazy Sizes doesnt’t require any configuration and it’s going to be included in your bundled js file.");
            article.setImgUrl("1.jpg");
            Article result = articleRepository.save(article);
            log.debug("" + result);
        }
    }
}