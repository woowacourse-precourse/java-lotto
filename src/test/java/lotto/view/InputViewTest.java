package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";
    Scanner scanner;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력 형식이 적절하지 않으면 예러를 발생한다.")
    void inputLottoMoneyImproperly() {
        String inputMoney = "만사천원";
        InputStream in = generateUserInput(inputMoney);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(InputView::inputMoney)
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_TYPE_IS_NOT_PROPER);
    }

    @Test
    @DisplayName("보너스 번호의 입력 형식이 적절하지 않으면 예러를 발생한다.")
    void inputBonusNumberImproperly() {
        String inputBonusNumber = "사십삼";
        InputStream in = generateUserInput(inputBonusNumber);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(InputView::inputBonusNumber)
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_TYPE_IS_NOT_PROPER);
    }

    @Test
    @DisplayName("로또 당첨 번호 입력 형식이 적절하지 않으면 예러를 발생한다.")
    void inputWinningLottoNumberImproperly() {
        String inputLottoNumber = "123456";
        InputStream in = generateUserInput(inputLottoNumber);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(InputView::inputWinningLotto)
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_TYPE_IS_NOT_PROPER);
    }
}