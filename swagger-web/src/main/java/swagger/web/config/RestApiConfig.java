package swagger.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;


/*
 *  @Configuration 配置注解，自动在本类上下文加载一些环境变量信息
	@EnableWebMvc 
	@EnableSwagger2 使swagger2生效
	@ComponentScan("com.myapp.packages") 需要扫描的包路径
	@ComponentScan(basePackages = {"com.<span style="font-family:Arial, Helvetica, sans-serif;">jay.</span>plat.config.controller"})
*/
@EnableWebMvc
@EnableSwagger 
@ComponentScan(basePackages = {"swagger.web.controller"})
@Configuration
public class RestApiConfig extends WebMvcConfigurationSupport{

	private SpringSwaggerConfig springSwaggerConfig;
	
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin  createRestApi() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.includePatterns("(/api/.*)|(/demo/.*)")
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringMvc integrate swagger for restful APIs")
				.description("this is a demo of swagger")
				.contact("wuyujia@beiquan.org")
				.build();
	}
}
