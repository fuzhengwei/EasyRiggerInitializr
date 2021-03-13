package cn.bugstack.initializr.rigger.domain.service.module.impl;

import cn.bugstack.initializr.rigger.domain.model.ProjectInfo;
import cn.bugstack.initializr.rigger.domain.service.module.BaseModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Service
public class GenerationYml extends BaseModule {

    private Logger logger = LoggerFactory.getLogger(GenerationYml.class);

    public void doGeneration(ProjectInfo projectInfo, String projectsRoot) throws Exception {

        File file = new File(
                projectsRoot + projectInfo.getArtifactId() + "/src/main/resources/",
                "application.yml"
        );

        // 写入文件
        super.writeFile(file, "yml.ftl", null);

        logger.info("创建配置文件 application.yml {}", file.getPath());
    }

}
