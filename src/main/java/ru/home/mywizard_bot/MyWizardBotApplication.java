package ru.home.mywizard_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWizardBotApplication {

    public static void main(String[] args) {
 //       System.getProperties().put( "proxySet", "true" );
 //       System.getProperties().put( "socksProxyHost", "127.0.0.1" );
 //       System.getProperties().put( "socksProxyPort", "9150" );

        SpringApplication.run(MyWizardBotApplication.class, args);
    }

}
