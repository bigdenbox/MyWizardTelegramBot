package ru.home.mywizard_bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ru.home.mywizard_bot.MyWizardTelegramBot;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
	private String webHookPath;
	private String botUserName;
	private String botToken;

//    private DefaultBotOptions.ProxyType proxyType;
//    private String proxyHost;
//    private int proxyPort;

	@Bean
	public MyWizardTelegramBot MySuperTelegramBot() {
		DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
		System.out.println("MySuperTelegramBot() started");

//        options.setProxyHost(proxyHost);
//        options.setProxyPort(proxyPort);
//        options.setProxyType(proxyType);

		MyWizardTelegramBot mySuperTelegramBot = new MyWizardTelegramBot(options);
		mySuperTelegramBot.setBotUserName(botUserName);
		mySuperTelegramBot.setBotToken(botToken);
		mySuperTelegramBot.setWebHookPath(webHookPath);
		System.out.println("webHookPath = " + webHookPath);
		System.out.println("botUserName = " + botUserName);
		System.out.println("botToken = " + botToken);
//        System.out.println("proxyHost = " + proxyHost);
//        System.out.println("proxyPort = " + proxyPort);
//        System.out.println("proxyType = " + proxyType);
//        System.out.println(mySuperTelegramBot.);

		return mySuperTelegramBot;
	}

//	public String getWebHookPath() {
//		return webHookPath;
//	}
//
//	public void setWebHookPath(String webHookPath) {
//		this.webHookPath = webHookPath;
//	}
//
//	public String getBotUserName() {
//		return botUserName;
//	}
//
//	public void setBotUserName(String botUserName) {
//		this.botUserName = botUserName;
//	}
//
//	public String getBotToken() {
//		return botToken;
//	}
//
//	public void setBotToken(String botToken) {
//		this.botToken = botToken;
//	}
}
