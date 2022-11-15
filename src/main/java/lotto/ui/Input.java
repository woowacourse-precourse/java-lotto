package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Answer;
import lotto.domain.Money;

import java.util.List;

public class Input {
    private InputMessages inputMessages;

    public Money buy() {
        inputMessages = InputMessages.MONEY;
        Money money;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        money = new Money(input);

        return money;
    }

    public Answer answer() {
        inputMessages = InputMessages.LOTTO;
        Answer answer;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        answer = new Answer(input);

        return answer;
    }

    public Answer bonus(Answer answer) {
        inputMessages = InputMessages.BONUS;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        answer.createBonus(input);

        return answer;
    }
}
