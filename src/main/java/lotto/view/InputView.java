package lotto.view;

import lotto.exception.InvalidInputException;
import lotto.domain.Money;

import java.util.NoSuchElementException;

public class InputView {
    private static final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "입력값이 비었습니다.";

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    private static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (NoSuchElementException e) {
            throw new InvalidInputException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        }
    }
}
