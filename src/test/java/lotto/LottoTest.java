package lotto;

import domain.Lotto;
import domain.NumberGenerator;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("NumberGenerator 테스트")
    @Test
    void createLottoNumber() {
        Lotto lottoNumber = NumberGenerator.createLottoNumber();
        List<Integer> numbers = lottoNumber.getNumbers();
        for (int tst = 0; tst < 10000000; ++tst) {
            for (int i = 1; i < numbers.size(); ++i) {
                if (numbers.get(i) < numbers.get(i - 1)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
