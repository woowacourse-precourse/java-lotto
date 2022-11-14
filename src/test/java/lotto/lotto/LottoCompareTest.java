package lotto.lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoCompareTest {
    LottoCompare compare = new LottoCompare();

    @Nested
    class CompareNumbersTest {
        @DisplayName("당첨번호가 5개가 있을 때 5값을 반환하는지")
        @Test
        void
        compareTest_1() {
            // given
            List<Integer> buyNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 7, 8);
            int result = 5;

            // when
            int compareCount = compare.getCompareCount(buyNumbers, prizeNumbers);

            // then
            assertThat(compareCount)
                    .isEqualTo(result);
        }

        @DisplayName("당첨번호가 1개가 있을 때 1값을 반환하는지")
        @Test
        void compareTest_2() {
            // given
            List<Integer> buyNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> prizeNumbers = List.of(1, 10, 11, 41, 51, 71, 81);
            int result = 1;

            // when
            int compareCount = compare.getCompareCount(buyNumbers, prizeNumbers);

            // then
            assertThat(compareCount)
                    .isEqualTo(result);
        }

        @DisplayName("당첨번호가 없을 때 0을 반환하는지")
        @Test
        void compareTest_3() {
            // given
            List<Integer> buyNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> prizeNumbers = List.of(9, 10, 11, 41, 51, 71, 81);
            int result = 0;

            // when
            int compareCount = compare.getCompareCount(buyNumbers, prizeNumbers);

            // then
            assertThat(compareCount)
                    .isEqualTo(result);
        }
    }

    @Nested
    class compareBonusTest {
        @DisplayName("보너스 번호가 구매한 로또에 있는지")
        @Test
        void compareTest_1() {
            // given
            List<Integer> buyNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 1;
            boolean result = true;

            // when
            boolean bonusCheck = compare.getBonusCheck(bonusNumber, buyNumbers);

            // then
            assertThat(bonusCheck)
                    .isEqualTo(result);
        }

        @DisplayName("보너스 번호가 구매한 로또에 없을 때")
        @Test
        void compareTest_2() {
            // given
            List<Integer> buyNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 15;
            boolean result = false;

            // when
            boolean bonusCheck = compare.getBonusCheck(bonusNumber, buyNumbers);

            // then
            assertThat(bonusCheck)
                    .isEqualTo(result);
        }
    }


}