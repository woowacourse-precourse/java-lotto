package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final Output output;

    public Input() {
        output = new Output();
    }

    public String getUserMoney() {
        output.printGetLottoPrice();

        String question = Console.readLine();

        return question;
    }

    public String getWinningNumber() {
        output.printGetWinningNumbers();

        String answer = Console.readLine();

        return answer;
    }

    public String getBonusNumber() {
        output.printGetBonusNumber();

        String answer = Console.readLine();

        return answer;
    }
}
