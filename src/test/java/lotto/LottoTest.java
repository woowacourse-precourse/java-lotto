package lotto;

import lotto.model.Lotto;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호가 1에서 45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,99", "0,10,20,30,40,45"})
    void createLottyByOutOFRangeNumber(int a, int b, int c, int d, int e, int f) {
        assertThatThrownBy(() -> new Lotto(List.of(a, b, c, d, e, f)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
