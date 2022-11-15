package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    @DisplayName("사용자 금액을 정상적으로 입력받는다.")
    @Test
    void makeMoneyInput() {
        InputStream in = generateUserInput("8000");
        System.setIn(in);
        int money = IOUtil.moneyInput();
        assertThat(money).isPositive();
        assertThat(money % 1000).isEqualTo(0);
    }
    @DisplayName("1000으로 나누어 떨어지지 않는 금액을 입력받으면 예외가 발생한다.")
    @Test
    void makeMoneyInputNotDividedBy1000() {
        InputStream in = generateUserInput("1234");
        System.setIn(in);
        assertThatThrownBy(IOUtil::moneyInput).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호를 정상적으로 입력받는다.")
    @Test
    void makeWinningNumbersInput() {
        InputStream in = generateUserInput("1,2,3,4,5,6");
        System.setIn(in);
        assertThat(IOUtil.answerNumberInput()).isInstanceOf(Lotto.class);
    }

    @DisplayName("당첨 번호에서 문자를 입력받았을 때 예외가 발생한다.")
    @Test
    void makeWinningNumbersInputWithCharacters() {
        InputStream in = generateUserInput("12,43$#@");
        System.setIn(in);
        assertThatThrownBy(IOUtil::answerNumberInput).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호에서 문자를 입력받았을 때 예외가 발생한다.")
    @Test
    void makeBonusNumberInputWithCharacter() {
        InputStream in = generateUserInput("$");
        System.setIn(in);
        assertThatThrownBy(IOUtil::bonusNumberInput).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("5개 일치, 보너스 볼 계산 테스트")
    @Test
    void secondWinningResultTest() {
        Lotto answer = new Lotto(List.of(1,2,3,4,6,8));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,7));
        int bonus = 5;
        WinningResult result = userLotto.calculate(answer, bonus).orElseThrow(() -> {throw new IllegalArgumentException("[ERROR] test error");});
        assertThat(result).isEqualTo(WinningResult.SECOND);
    }


    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
