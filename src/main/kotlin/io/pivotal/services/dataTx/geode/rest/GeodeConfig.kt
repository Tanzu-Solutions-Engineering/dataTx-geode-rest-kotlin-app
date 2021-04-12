package io.pivotal.services.dataTx.geode.rest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.gemfire.config.annotation.EnablePdx
import org.springframework.data.gemfire.config.annotation.EnableSecurity
import org.springframework.data.gemfire.config.annotation.EnableStatistics


/**
 * @author Gregory Green
 */
@Configuration
@EnablePdx(readSerialized = true)
@EnableStatistics
public class GeodeConfig
{
//    @Value("\${spring.data.gemfire.pool.locators}")
//    lateinit var locators: String;
//
//
//    @Value("\${spring.security.user.name}")
//    lateinit var userName: String;
//
//    @Value("\${spring.security.user.password}")
//    lateinit var password: String;
//
//
//    //spring.data.gemfire.name
//    @Value("\${spring.data.gemfire.name}")
//    lateinit var name: String;


}