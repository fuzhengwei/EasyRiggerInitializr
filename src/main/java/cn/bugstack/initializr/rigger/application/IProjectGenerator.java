package cn.bugstack.initializr.rigger.application;

import cn.bugstack.initializr.rigger.domain.model.ProjectInfo;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface IProjectGenerator {

    void generator(ProjectInfo projectInfo) throws Exception;

}
