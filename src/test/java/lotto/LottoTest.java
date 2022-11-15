package lotto;

import lotto.reward.*;
import lotto.utils.LottoRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new RewardNumbers("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new RewardNumbers("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 성공한 경우")
    @Test
    void createLottoSucceedInput() {
        Console console = System.console();
    }
    // 아래에 추가 테스트 작성 가능

    @Test
    void 양수가_아닌_값() {
        assertThatThrownBy(() -> new RewardNumbers("-1, 0, 1, 2 ,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_범위() {
        assertThatThrownBy(() -> new RewardNumbers("1, 3, 40, 42, 46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

