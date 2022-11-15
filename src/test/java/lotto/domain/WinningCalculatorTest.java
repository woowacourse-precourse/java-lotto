package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @Nested
    class SetWinningNumbers {

        @DisplayName("당첨 번호 설정 후, 동일한 번호의 로또 결과 계산 -> 1등 반환")
        @Test
        void should_BeRank1_When_SetWinningNumbersBySameNumbers() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 11));
            Lotto lottoBeforeResetWinningNumbers = new Lotto(numbers);
            // when
            winningCalculator.setWinningNumbers("6,7,8,9,10,11");
            // then
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lottoBeforeResetWinningNumbers);
            assertThat(winningResult).isEqualTo(WinningResult.RANK_1);
        }

        @DisplayName("int 범위 밖의 숫자 포함 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_HaveNumberInOuterRangeOfInt() {
            assertThatThrownBy(() -> winningCalculator.setWinningNumbers("1,2,3,4,5,2200000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정해진 개수와 다른 개수의 숫자 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsNotCorrectSize() {
            assertThatThrownBy(() -> winningCalculator.setWinningNumbers("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정해진 번호 범위 바깥의 수 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_HaveNumberInOuterRange() {
            assertThatThrownBy(() -> winningCalculator.setWinningNumbers("1,2,3,46,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 번호 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_HaveDuplicatedNumber() {
            assertThatThrownBy(() -> winningCalculator.setWinningNumbers("1,2,3,4,5,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스 번호를 설정한다.")
    @Nested
    class SetBonusNumber {

        @DisplayName("로또 번호와 일치하는 보너스 번호 설정 후, 결과 계산 -> 2등 반환")
        @Test
        void should_BeRank2_When_SetBonusNumber() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));
            Lotto lottoBeforeResetBonusNumber = new Lotto(numbers);
            // when
            winningCalculator.setBonusNumber("8");
            // then
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lottoBeforeResetBonusNumber);
            assertThat(winningResult).isEqualTo(WinningResult.RANK_2);
        }

        @DisplayName("int 범위 밖의 숫자 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsInOuterRangeOfInt() {
            assertThatThrownBy(() -> winningCalculator.setBonusNumber("2200000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정해진 번호 범위 바깥의 수 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsInOuterRangeOfRule() {
            assertThatThrownBy(() -> winningCalculator.setBonusNumber("46"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 이미 포함된 번호 입력 -> 예외발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsAlreadyInWinningNumber() {
            assertThatThrownBy(() -> winningCalculator.setBonusNumber("6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("로또 1개의 당첨 여부를 계산한다.")
    @Nested
    class calculateResultOfLotto {

        @DisplayName("당첨 번호와 1개 일치 -> 꽝 반환")
        @Test
        void should_BeRankNone_When_Contain1WinningNumber() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 7, 8, 9, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_NONE);
        }

        @DisplayName("당첨 번호와 3개 일치 -> 5등 반환")
        @Test
        void should_BeRank5_When_Contain3WinningNumbers() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 9, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_5);
        }

        @DisplayName("당첨 번호와 4개 일치 -> 4등 반환")
        @Test
        void should_BeRank4_When_Contain4WinningNumbers() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 30));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_4);
        }

        @DisplayName("당첨 번호와 5개 일치 -> 3등 반환")
        @Test
        void should_BeRank3_When_Contain5WinningNumbers() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 30));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_3);
        }

        @DisplayName("당첨 번호와 5개 일치, 보너스 번호 포함 -> 2등 반환")
        @Test
        void should_BeRank2_When_Contain5WinningNumbersAndBonus() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_2);
        }

        @DisplayName("당첨 번호와 6개 일치 -> 1등 반환")
        @Test
        void should_BeRank1_When_Contain6WinningNumbers() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);
            // when
            WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
            // then
            assertThat(winningResult).isEqualTo(WinningResult.RANK_1);
        }
    }
}