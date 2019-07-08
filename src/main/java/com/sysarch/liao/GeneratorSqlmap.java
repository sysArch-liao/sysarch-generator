package com.sysarch.liao;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 获取mybatis配置文件的File对象的三种方法 start
		//方法一 通过java的api获取
//		ClassLoader classLoader = getClass().getClassLoader();
//		URL url = classLoader.getResource("generator-config/generatorConfig.xml");
//		File configFile = new File(url.getFile());
		// 方法二  通过绝对路径获取
//		File configFile = new File("F:\\devmProject\\myProject\\sysarch-generator\\src\\main\\resources\\generatorConfig.xml");
		// 方法三()  Resources是mybatis的一个类在org.apache.ibatis.io.Resources路径下面
		File configFile = Resources.getResourceAsFile("generator-config/generatorConfig.xml");
		// 获取mybatis配置文件的File对象的三种方法 end
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	} 
	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
