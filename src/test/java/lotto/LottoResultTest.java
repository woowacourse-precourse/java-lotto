package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @DisplayName("로또 당첨번호가 7개 이상이면 예외가 발생한다")
    @Test
    void checkLottoAnswerNumUp() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호가 5개 이하이면 예외가 발생한다")
    @Test
    void checkLottoAnswerNumDown() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호가 46이상이면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,46"})
    @ParameterizedTest
    void checkLottoAnswerUp(String input) {
        ArrayList<Integer> lottoAnswer = new ArrayList<>();
        assertThatThrownBy(() -> Lotto.validateInput(lottoAnswer, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호가 0이하이면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,0"})
    @ParameterizedTest
    void checkLottoAnswerDown(String input) {
        ArrayList<Integer> lottoAnswer = new ArrayList<>();
        assertThatThrownBy(() -> Lotto.validateInput(lottoAnswer, input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 당첨번호입력이 양식에 안맞으면 예외가 발생한다")
    @ValueSource(strings = {"123456", "1.2.3.4.5.6"})
    @ParameterizedTest
    void checkLottoAnswerType(String input) {
        ArrayList<Integer> lottoAnswer = new ArrayList<>();
        assertThatThrownBy(() -> Lotto.validateInput(lottoAnswer, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호가 중복되면 예외가 발생한다")
    @Test
    void checkLottoAnswerDup() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
