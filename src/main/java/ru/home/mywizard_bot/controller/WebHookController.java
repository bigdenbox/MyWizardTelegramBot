package ru.home.mywizard_bot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.mywizard_bot.MyWizardTelegramBot;

@RestController
public class WebHookController {
	private final MyWizardTelegramBot telegramBot;

	public WebHookController(MyWizardTelegramBot telegramBot) {
		this.telegramBot = telegramBot;
		System.out.println("Constructor WebHookController is started");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
		java.util.Date time=new java.util.Date((long)update.getMessage().getDate() * 1000);
		System.out.println("Date: " + time + " ChatID:" + update.getMessage().getChatId() + ". IN  message: " + update.getMessage().getText());
		return telegramBot.onWebhookUpdateReceived(update);
	}

}
