package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호는 오름차순으로 정렬되어야한다.")
    @Test
    void createLottoSortAsc() {
        // given
        Lotto lotto = new Lotto(List.of(5, 1, 2, 10, 4, 7));
        List<LottoNumber> temp = new ArrayList<>();

        // when
        for (LottoNumber lottoNumber : lotto) {
            temp.add(lottoNumber);
        }

        // then
        for (int i = 0; i < temp.size() - 1; ++i) {
            LottoNumber beforeNumber = temp.get(i);
            LottoNumber afterNumber = temp.get(i + 1);
            assertThat(beforeNumber.compareTo(afterNumber)).isLessThanOrEqualTo(-1);
        }
    }

}
