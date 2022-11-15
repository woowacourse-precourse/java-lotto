package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("로또의 각 번호가 1~45 범위를 넘어서면 예외가 발생한다. ")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void 로또_번호가_범위를_벗어나게_생성(int outOfRangeNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(outOfRangeNumber, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또끼리 번호를 비교할 수 있다. ")
    @Test
    void 로또_번호_비교_3개가_같을_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int count = lotto.countMatchNumber(new Lotto(List.of(1, 2, 3, 23, 45, 22)));
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("로또 번호에 특정 숫자가 포함되어있는지 확인할 수 있다. ")
    @ParameterizedTest
    @CsvSource({"1,true", "9,false"})
    void 로또_번호에_숫자1이_포함되고_9가_포함되지_않게_생성(int containsNum, boolean result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean isContains = lotto.contains(containsNum);
        assertThat(isContains).isEqualTo(result);
    }
}
