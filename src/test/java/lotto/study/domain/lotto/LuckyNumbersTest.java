package lotto.study.domain.lotto;

import lotto.domain.ingame.Lotto;
import lotto.domain.ingame.LuckyNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LuckyNumbersTest {

    @DisplayName("당첨 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_값_테스트1() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 2, 3, 4, 5, 46),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_값_테스트2() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 0, 3, 4, 5, 45),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_중복_테스트() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 2, 3, 4, 5, 5),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_테스트() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 보너스번호_값_테스트1() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 2, 3, 4, 5, 6),46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")

    @Test
    void 보너스번호_값_테스트2() {
        assertThatThrownBy(() -> new LuckyNumbers(List.of(1, 2, 3, 4, 5, 6),0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}