package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class QuizAppApplication implements CommandLineRunner {

	@Autowired
	private AttemptService attemptService;

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Attempt attempt = attemptService.getAttempt(1, 301);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("User: " + attempt.getUser().getName());
		System.out.println("Attempt Date: " + sdf.format(attempt.getDate()));
		System.out.println();

		attempt.getAttemptQuestionList().forEach(aq -> {
			System.out.println(aq.getQuestion().getText());
			aq.getAttemptOptionList().forEach(ao -> {
				Options op = ao.getOption();
				System.out.printf(" %s\t%.1f\t%b%n", op.getText(), op.getScore(), ao.isSelected());
			});
			System.out.println();
		});
	}
}
