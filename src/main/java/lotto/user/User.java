package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class User {

    public Integer getInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            UserValidator userValidator = new UserValidator();
            String input = Console.readLine();
            return userValidator.toInteger(input);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
        }
    }
}
