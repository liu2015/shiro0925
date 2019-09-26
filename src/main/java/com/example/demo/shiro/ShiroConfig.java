package com.example.demo.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
@Bean(name="shiroFilterFactoryBean")
public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
    ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

    shiroFilterFactoryBean.setSecurityManager( defaultWebSecurityManager );
    Map<String,String> fMap=new HashMap<String, String>(  );

    fMap.put( "/","authc" );
    fMap.put( "/one","authc" );
    fMap.put( "/two","authc" );
    fMap.put( "/index","authc" );


    fMap.put( "/one","perms[管理员]" );
    fMap.put( "/two","perms[管理员]" );
//    fMap.put( "/index/*","perms[管理员]" );

    shiroFilterFactoryBean.setLoginUrl( "/login" );

    shiroFilterFactoryBean.setUnauthorizedUrl( "/permission" );
    shiroFilterFactoryBean.setFilterChainDefinitionMap( fMap );
    return  shiroFilterFactoryBean;

}

    @Bean(name="defaultWebSecurityManager")
    public  DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm ) {
        DefaultWebSecurityManager defaultWebSecurityManager =new DefaultWebSecurityManager(  );
        defaultWebSecurityManager.setRealm( userRealm );
        return defaultWebSecurityManager;

    }



//    创建一个自定义域
    @Bean(name="userRealm")
    public UserRealm getUserRealm (){
        return new UserRealm();
    }




}
