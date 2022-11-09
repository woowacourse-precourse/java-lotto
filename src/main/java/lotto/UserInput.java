package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public Count inputPrice() {
        System.out.println("구입 금액을 입력해주세요.");
        String userInput = Console.readLine();
        return new Count(userInput);
    }
}
