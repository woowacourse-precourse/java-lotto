package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class LottoScanner {

    private static final String NOT_ONLY_NUMBER = "숫자만 입력해 주세요";

    // 숫자 한개를 입력받는 로직 : 돈, 보너스 번호 (숫자 한개를 입력받기 때문에 같은 로직 사용.)
    public String number() {
        String number = readLine();
        validateItContainsOnlyNumber(number);

        return number;
    }

    // 형식이 있는 문자열을 입력받는 로직 : 당첨 번호를 입력받는데 사용
    public String formattedNumber() {
        return readLine();
    }

    // NoSuchElementException 방지
    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    void validateItContainsOnlyNumber(String money) {
        final String REGEX = "\\d+";
        if (!money.matches(REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER);
        }
    }
}
