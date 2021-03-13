package cn.bugstack.initializr.rigger.infrastructure.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class TemplateUtils {

    /**
     * freemarker 配置
     */
    private static Configuration cfg = new Configuration();
    ;

    /**
     * 获取模板跟地址
     *
     * @return
     */
    public static URL getTemplatePath() {
        return TemplateUtils.class.getResource("");
    }

    /**
     * 获取 freemarker 配置
     *
     * @return
     * @throws IOException
     */
    public static Configuration getConfiguration() throws IOException {
        cfg.setDirectoryForTemplateLoading(new File(getTemplatePath().getPath()));
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        return cfg;
    }

}
