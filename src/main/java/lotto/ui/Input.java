package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Answer;
import lotto.domain.Money;


public class Input {
    private static InputMessages inputMessages;

    public static boolean buy(Money money) {
        inputMessages = InputMessages.MONEY;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        if (!money.validate(input)) {
            return false;
        }
        money.createMoney(input);
        return true;
    }

    public static boolean answer(Answer answer) {
        inputMessages = InputMessages.LOTTO;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        if (!answer.validate(input)) {
            return false;
        }
        answer.createAnswer(input);
        return true;
    }

    public static boolean bonus(Answer answer) {
        inputMessages = InputMessages.BONUS;
        String input;

        System.out.println(inputMessages.getAction());
        input = Console.readLine();
        if (!answer.validateBonus(input)) {
            return false;
        }
        answer.createBonus(input);
        return true;
    }
}
