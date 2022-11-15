package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByContainsDuplicateBonusNum() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위 밖의 수를 입력 받으면 예외가 발생한다.(1 ~ 45)")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, -1, 6",
            "1, 2, 3, 4, 5, 100, 7",
            "1, 2, 3, 4, 5, 6, -1" ,
            "1, 2, 3, 4, 5, 6, 100"})
    void createLottoByContainsOutArrangeNum(int num1, int num2, int num3, int num4, int num5, int num6, int bonusNum) {
        assertThatThrownBy(() -> new Lotto(List.of(num1, num2, num3, num4, num5, num6), bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
