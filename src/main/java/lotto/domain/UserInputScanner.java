package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputScanner {
    public Integer askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = readLine();

        Validator validator = new Validator();

        try {
            validator.validateUserInput(userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return Integer.parseInt(userInput);
    }
}
