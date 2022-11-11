package lotto.domain;

import static lotto.exception.ValidatorTest.WINNING_NUMBERS;
import static lotto.service.LottoServiceTest.BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("Lotto - numbers의 불변 여부 테스트")
    class ImmutabilityTest {

        @DisplayName("로또를 생성하는데 쓰인 리스트를 변경시켜도 불변 유지")
        @Test
        void test1() {
            List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
            Lotto lotto = new Lotto(list);
            list.add(7);
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }

        @DisplayName("Lotto에 getter를 통해 값을 추가하면 예외 반환")
        @Test
        void test2() {
            List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
            Lotto lotto = new Lotto(list);
            assertThatThrownBy(() -> lotto.getNumbers().add(7))
                    .isInstanceOf(UnsupportedOperationException.class);
        }
    }

    @Nested
    @DisplayName("compareWinningNumbers method")
    class MethodTest {

        @DisplayName("당첨번호가 6개인 경우")
        @Test
        void test1() {

            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(6);
        }

        @DisplayName("당첨번호가 5개인 경우")
        @Test
        void test2() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(5);
        }

        @DisplayName("당첨번호가 4개인 경우")
        @Test
        void test3() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 44, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(4);
        }

        @DisplayName("당첨번호가 3개인 경우.")
        @Test
        void test4() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(3);
        }

        @DisplayName("당첨번호가 2개인 경우")
        @Test
        void test5() {
            Lotto lotto = new Lotto(List.of(1, 2, 42, 43, 44, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(2);
        }

        @DisplayName("당첨번호가 1개인 경우")
        @Test
        void test6() {
            Lotto lotto = new Lotto(List.of(1, 41, 42, 43, 44, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(1);
        }

        @DisplayName("당첨번호가 0개인 경우")
        @Test
        void test7() {
            Lotto lotto = new Lotto(List.of(40, 41, 42, 43, 44, 45));
            assertThat(lotto.compareWinningNumbers(WINNING_NUMBERS)).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("isContainBonusNumber method")
    class MethodTest2 {

        @DisplayName("보너스 번호가 일치하는 경우")
        @Test
        void test1() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            assertThat(lotto.isContainBonusNumber(BONUS_NUMBER)).isTrue();
        }

        @DisplayName("보너스 번호가 일치하지 않는 경우")
        @Test
        void test2() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lotto.isContainBonusNumber(BONUS_NUMBER)).isFalse();
        }
    }

}
