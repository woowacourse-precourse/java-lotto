package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static final String LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1000원 이하입니다.";
    private static final String LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1000원으로 나누어 떨어지지 않습니다.";
    Scanner scanner;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("최소 구입 금액 이하의 값을 입력했을 때 예외를 잘 발생시키는지 확인한다.")
    void inputLottoMoneyUnderMinimumMoney() {
        String inputMoney = "900";
        InputStream in = generateUserInput(inputMoney);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(InputView::inputMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE);
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원으로 나누어지지 않으면 예외를 잘 발생시키는지 확인한다.")
    void inputLottoMoneyNotDividedBy1000() {
        String inputMoney = "1100";
        InputStream in = generateUserInput(inputMoney);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(InputView::inputMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE);
    }
}