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

	@Bean
	public MyWizardTelegramBot MySuperTelegramBot() {
		DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
		System.out.println("MySuperTelegramBot() started");

		MyWizardTelegramBot mySuperTelegramBot = new MyWizardTelegramBot(options);
		mySuperTelegramBot.setBotUserName(botUserName);
		mySuperTelegramBot.setBotToken(botToken);
		mySuperTelegramBot.setWebHookPath(webHookPath);
		System.out.println("webHookPath = " + webHookPath);
		System.out.println("botUserName = " + botUserName);
		System.out.println("botToken = " + botToken);

		return mySuperTelegramBot;
	}

}
