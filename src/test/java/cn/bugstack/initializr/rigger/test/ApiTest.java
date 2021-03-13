package cn.bugstack.initializr.rigger.test;

import cn.bugstack.initializr.rigger.application.IProjectGenerator;
import cn.bugstack.initializr.rigger.domain.model.ApplicationInfo;
import cn.bugstack.initializr.rigger.domain.model.ProjectInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IProjectGenerator iProjectGenerator;

    @Test
    public void test_IProjectGenerator() throws Exception {

        ProjectInfo projectInfo = new ProjectInfo(
                "cn.bugstack.demo",
                "web-test",
                "1.0.0-SNAPSHOT",
                "web-test",
                "Demo project for Spring Boot"
        );

        iProjectGenerator.generator(projectInfo);
    }

}
