package cn.bugstack.initializr.rigger.domain.service;

import cn.bugstack.initializr.rigger.application.IProjectGenerator;
import cn.bugstack.initializr.rigger.domain.model.ProjectInfo;
import cn.bugstack.initializr.rigger.domain.service.module.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Arrays;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Service
public class ProjectGeneratorImpl implements IProjectGenerator {

    private Logger logger = LoggerFactory.getLogger(ProjectGeneratorImpl.class);

    @Resource
    private GenerationApplication generationApplication;
    @Resource
    private GenerationYml generationYml;
    @Resource
    private GenerationPom generationPom;
    @Resource
    private GenerationTest generationTest;
    @Resource
    private GenerationIgnore generationIgnore;
    @Resource
    private GenerationPackageInfo generationPackageInfo;

    @Override
    public void generator(ProjectInfo projectInfo) throws Exception {

        URL resource = this.getClass().getResource("/");
        String projectsRoot = resource.getFile() + "/projects/";

        String lastPackageName = projectInfo.getArtifactId().replaceAll("-", "").toLowerCase();
        //启动类名称
        String[] split = projectInfo.getArtifactId().split("-");
        StringBuffer applicationJavaName = new StringBuffer();
        Arrays.asList(split).forEach(s -> {
            applicationJavaName.append(s.substring(0, 1).toUpperCase() + s.substring(1));
        });
        applicationJavaName.append("Application");

        // 1. 创建  Application.java
        generationApplication.doGeneration(projectInfo, projectsRoot, lastPackageName, applicationJavaName);

        // 2. 生成 application.yml
        generationYml.doGeneration(projectInfo, projectsRoot);

        // 3. 生成 pom.xml
        generationPom.doGeneration(projectInfo, projectsRoot);

        // 4. 创建测试类 ApiTest.java
        generationTest.doGeneration(projectInfo, projectsRoot, lastPackageName, applicationJavaName);

        // 5. 生成 .gitignore
        generationIgnore.doGeneration(projectInfo, projectsRoot);

        // 6. DDD 四层描述文件
        generationPackageInfo.doGeneration(projectInfo, projectsRoot, lastPackageName, applicationJavaName);

    }

}
