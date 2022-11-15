package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("숫자에 콤마가 잘 삽입되는지 확인한다.")
    @Test
    void addComma() {
        assertThat(Application.addComma(3000))
                .isEqualTo("3,000");
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않을 때 예외가 발생한다.")
    @Test
    void validateMoney() {
        assertThatThrownBy(() -> Application.validateMoney(3500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 이상하면 예외가 발생한다.")
    @Test
    void getWinningNumbers() {
        String input = "1,2,3,5,7,81";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Application::getWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이상하면 예외가 발생한다.")
    @Test
    void getBonusNumber() {
        String input = "54";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Application::getBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 이상하면 예외가 발생한다.")
    @Test
    void howManyLotto() {
        String input = "54j";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Application::howManyLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률이 잘 계산되는지 확인한다.")
    @Test
    void printRateOfReturn() {
        Long totalMoney = 50000L;
        int inputMoney = 3000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.printRateOfReturn(totalMoney, inputMoney);
        assertThat(out.toString().trim()).contains("총 수익률은 1,666.7%입니다.");
    }
}