package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @DisplayName("복권 번호를 받으면 등수를 계산한다.")
    @Nested
    class createLottoRank {

        @Test
        void case1() {
            List<Integer> example = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> lottoNumber = List.of(1, 3, 4, 5, 6, 7, 2);
            Lotto one = new Lotto(example);
            int result = one.confirmNumbers(lottoNumber);
            assertThat(result).isEqualTo(2);
        }

        @Test
        void case2() {
            List<Integer> example = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> lottoNumber = List.of(1, 3, 4, 5, 6, 7, 9);
            Lotto one = new Lotto(example);
            int result = one.confirmNumbers(lottoNumber);
            assertThat(result).isEqualTo(3);
        }
    }

}
