package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {
    WinningCalculator winningCalculator = new WinningCalculator();

    @BeforeEach
    void initWinningCalculator() {
        winningCalculator.setWinningNumbers("1,2,3,4,5,6");
        winningCalculator.setBonusNumber("7");
    }

    @DisplayName("당첨 번호를 설정한다.")
    @Test
    void ShouldBeRank1WhenSetWinningNumbers() {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 11));
        Lotto lottoBeforeResetWinningNumbers = new Lotto(numbers);
        // when
        winningCalculator.setWinningNumbers("6,7,8,9,10,11");
        // then
        assertThat(winningCalculator.getResultOfOneLotto(lottoBeforeResetWinningNumbers))
                .isEqualTo(WinningResult.RANK_1);
    }

    @DisplayName("보너스 번호를 설정한다.")
    @Test
    void ShouldBeRank2WhenSetBonusNumber() {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lottoBeforeResetWinningNumbers = new Lotto(numbers);
        // when
        winningCalculator.setBonusNumber("8");
        // then
        assertThat(winningCalculator.getResultOfOneLotto(lottoBeforeResetWinningNumbers))
                .isEqualTo(WinningResult.RANK_2);
    }

    @DisplayName("로또 1개의 당첨 여부를 계산한다.")
    @Nested
    class calculateResultOfLotto {

        @DisplayName("꽝인 경우")
        @Test
        void getClassNone() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 7, 8, 9, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_NONE);
        }

        @DisplayName("5등인 경우")
        @Test
        void getClass5() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 9, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_5);
        }

        @DisplayName("4등인 경우")
        @Test
        void getClass4() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_4);
        }

        @DisplayName("3등인 경우")
        @Test
        void getClass3() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 30));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_3);
        }

        @DisplayName("2등인 경우")
        @Test
        void getClass2() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_2);
        }

        @DisplayName("1등인 경우")
        @Test
        void getClass1() {
            // given
            // when
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);
            // then
            assertThat(winningCalculator.getResultOfOneLotto(lotto)).isEqualTo(WinningResult.RANK_1);
        }

    }
}