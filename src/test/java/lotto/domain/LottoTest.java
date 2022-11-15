package lotto.domain;

import lotto.utils.ExceptionMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Nested
    @DisplayName("로또 번호 유효성 테스트")
    class LottoValidation {
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_ONLY_SIX_SIZE);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_ONLY_UNIQUE_NUMBERS);
        }

        @DisplayName("로또 번호에 1미만이 있으면 예외가 발생한다.")
        @Test
        void OutOfLottoNumberMinRangeExceptionTest() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Lotto(List.of(1, 2, 3, 0, 5, 6)));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }

        @DisplayName("로또 번호에 45초과가 있으면 예외가 발생한다.")
        @Test
        void OutOfLottoNumberMaxRangeExceptionTest() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Lotto(List.of(1, 2, 3, 46, 5, 6)));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("로또 정렬 테스트")
    class LottoSorting {
        @DisplayName("로또 번호 오름차순 정렬 테스트")
        @Test
        void sortLottoNumberTest() {
            ArrayList<Integer> compareData = new ArrayList<>(List.of(20, 14, 8, 5, 2, 1));
            Lotto lotto = new Lotto(compareData);
            Collections.sort(compareData);

            assertThat(lotto.isSortedLottoNumbers(compareData)).isEqualTo(true);
        }

        @DisplayName("로또 번호 오름차순 정렬 실패 테스트")
        @Test
        void sortLottoNumberFailTest() {
            ArrayList<Integer> compareData = new ArrayList<>(List.of(20, 14, 8, 5, 2, 1));
            Lotto lotto = new Lotto(compareData);

            assertThat(lotto.isSortedLottoNumbers(compareData)).isEqualTo(true);
        }
    }
}
