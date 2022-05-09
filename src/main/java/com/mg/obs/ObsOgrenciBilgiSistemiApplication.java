package com.mg.obs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.mg.obs.*")
public class ObsOgrenciBilgiSistemiApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ObsOgrenciBilgiSistemiApplication.class, args);
	}
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // add configuration here
    }

}
