package lotto;

import lotto.lotteryshop.Lotto;
import lotto.validator.UserInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1() {
        String[] inputValue = {"1", "2", "0", "4", "5", "6"};
        assertThatThrownBy(() -> UserInputValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
