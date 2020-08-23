package ru.home.mywizard_bot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class MyWizardTelegramBot extends TelegramWebhookBot {
	private String webHookPath;
	private String botUserName;
	private String botToken;

	public MyWizardTelegramBot(DefaultBotOptions botOptions) {
		super(botOptions);
//		super(new DefaultBotOptions());
		System.out.println("Constructor MyWizardTelegramBot(DefaultBotOptions botOptions) is started");
		System.out.println("botOptions.getProxyHost(): " + botOptions.getProxyHost());
		System.out.println("botOptions.getBaseUrl(): " + botOptions.getBaseUrl());
		System.out.println("botOptions.getHttpContext(): " + botOptions.getHttpContext());
		System.out.println("botOptions.getProxyPort(): " + botOptions.getProxyPort());

	}

	@Override
	public String getBotToken() {
		return botToken;
	}

	@Override
	public String getBotUsername() {
		return botUserName;
	}

	@Override
	public String getBotPath() {
		return webHookPath;
	}
	
	public void PrintAnswerToConsol(SendMessage answer, Date date) {
		System.out.println("Date: " + date + " ChatID:" + answer.getChatId() + ". OUT message: "
				+ answer.getText());
	}

	@Override
	public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
		SendMessage answer = null;
		if (update.getMessage() != null && update.getMessage().hasText()) {
			long chat_id = update.getMessage().getChatId();

			try {
				answer = new SendMessage(chat_id, "Hi " + update.getMessage().getText());
				execute(answer);
				Date date = new java.util.Date((long) update.getMessage().getDate() * 1000);
				PrintAnswerToConsol(answer, date);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void setWebHookPath(String webHookPath) {
		this.webHookPath = webHookPath;
		System.out.println("public void setWebHookPath(String webHookPath) this.webHookPath =" + this.webHookPath);
	}

	public void setBotUserName(String botUserName) {
		this.botUserName = botUserName;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}

}
