package com.tearsmart.seckill.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.config.rules.PropertyInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author liuyl
 * @date 2018-10-23-17:10
 * @description
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath );
        gc.setAuthor("tear-smart");
        gc.setActiveRecord(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/miaosha?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setTypeConvert(new MySqlTypeConvert(){
            @Override
           public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
               return super.processTypeConvert(globalConfig, fieldType);
           }


        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName(scanner("模块名"));
        pc.setParent("com.tearsmart.seckill");
        pc.setEntity("domain");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // // 自定义配置
        // InjectionConfig cfg = new InjectionConfig() {
        //     @Override
        //     public void initMap() {
        //         // to do nothing
        //     }
        // };
        // List<FileOutConfig> focList = new ArrayList<>();
        // focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
        //     @Override
        //     public String outputFile(TableInfo tableInfo) {
        //         // 自定义输入文件名称
        //         return projectPath + "/resources/mapper/"
        //                 // + pc.getModuleName()
        //                 + "/" + tableInfo.getEntityName() + "Mapper" ;
        //     }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);
        // mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix("");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("com.lyl.mongo.common.BaseEntity");
        // strategy.setEntityLombokModel(true);
        // strategy.setRestControllerStyle(true);
        // strategy.setSuperMapperClass("com.lyl.mongo.common.Mapper");
        // strategy.setSuperControllerClass("com.lyl.mongo.common.BaseController");
        // strategy.setSuperServiceClass("com.lyl.mongo.common.BaseService");
        // strategy.setSuperServiceImplClass("com.lyl.mongo.common.BaseServiceImpl");
        // strategy.setInclude("goods");
        // strategy.setSuperEntityColumns("id");
        // strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }
}
