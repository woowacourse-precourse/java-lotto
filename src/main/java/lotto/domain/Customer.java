package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

/**
 * 로또 프로그램 사용자의 행동 반영
 * 로또 구매
 * 당첨 번호 확인
 * 수익률 반영
 */
public class Customer {
    private List<Lotto> lottos;
    private final String ERROR_FORMAT = "[ERROR] %s";

    public int pay() {
        System.out.print("구입금액을 입력해 주세요: ");
        String fee = readLine();
        validateNumeric(fee);
        validateMultiplesOf1000(fee);
        return Integer.parseInt(fee);
    }

    private void validateNumeric(String stringNumber) {
        if (!stringNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_FORMAT.format("구매 금액은 숫자여야 합니다."));
        }
    }

    private void validateMultiplesOf1000(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_FORMAT.format("구매 금액은 1000원 단위여야 합니다."));
        }
    }

}
