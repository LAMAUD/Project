package fr.treeptik.i18n.messages;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class TestMessageSource implements MessageSourceAware {

	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void printMessage() {
		String name = messageSource.getMessage("welcome.to.treeptik", null,
				Locale.FRANCE);

		System.out.println("test france: " + name);

		String nameEnglish = messageSource.getMessage("welcome.to.treeptik",
				null, Locale.ENGLISH);

		System.out.println("test anglais : " + nameEnglish);
	}

}
