package cn.bugstack.initializr.rigger.domain.service.module.impl;

import cn.bugstack.initializr.rigger.domain.model.ApplicationInfo;
import cn.bugstack.initializr.rigger.domain.model.ProjectInfo;
import cn.bugstack.initializr.rigger.domain.service.module.BaseModule;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Service
public class GenerationTest extends BaseModule {

    private Logger logger = LoggerFactory.getLogger(GenerationTest.class);

    public void doGeneration(ProjectInfo projectInfo, String projectsRoot, String lastPackageName, StringBuffer applicationJavaName) throws Exception {
        ApplicationInfo applicationInfo = new ApplicationInfo(
                projectInfo.getGroupId() + "." + lastPackageName,
                applicationJavaName.toString()
        );

        String packagePath = applicationInfo.getPackageName().replace(".", "/") + "/";

        File file = new File(projectsRoot + projectInfo.getArtifactId() + "/src/test/java/" + packagePath,
                "ApiTest.java");

        // 写入文件
        super.writeFile(file, "test.ftl", applicationInfo);

        logger.info("创建测试类 ApiTest.java {}", file.getPath());
    }

}
