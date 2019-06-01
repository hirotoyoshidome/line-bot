package jp.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class AppSample {
	public static void main(String[] args) {
		SpringApplication.run(AppSample.class, args);
	}

	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		System.out.println("event : " + event);
		return new TextMessage("変換していく～\r\n" + ConvertMorse.convertMorseSignal(event.getMessage().getText()));
	}

	@EventMapping
	public void handleDefaultEvent(Event event) {
		System.out.println("event : " + event);
	}
}
