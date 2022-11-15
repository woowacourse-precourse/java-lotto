package lotto;

import lotto.lottoChecker.LottoChecker;
import lotto.lottoChecker.LottoCheckerImpl;
import lotto.lottoChecker.WaysToWinAndRewards;
import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;
import lotto.numbers.WinningNumbersImpl;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LottoCheckerTest {
    @Nested
    @DisplayName("checkLottosTest")
    public class checkLottosTest {
        @Test
        void test() {
            //given
            List<Integer> winningMainNumbers = List.of(1, 2, 3, 4, 5, 6);
            int winningBonusNumber = 7;
            WinningNumbers winningNumbers = new WinningNumbersImpl(winningMainNumbers, winningBonusNumber);
            LottoChecker lottoChecker = new LottoCheckerImpl(winningNumbers);
            Lotto lotto1st = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto4th = new Lotto(List.of(1, 2, 3, 4, 9, 7));
            //when
            lottoChecker.checkLottos(List.of(lotto1st, lotto4th));
            int[] rankResult = lottoChecker.getRankResult();
            int rewardResult = lottoChecker.getRewardResult();
            //then
            assertThat(rankResult)
                    .isEqualTo(new int[] {0, 1, 0, 0, 1, 0, 0});
            assertThat(rewardResult)
                    .isEqualTo(WaysToWinAndRewards.FIRST.getReward() + WaysToWinAndRewards.FOURTH.getReward());
        }
    }
    @Nested
    @DisplayName("checkHowManyMatchesTest")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class checkHowManyMatchesTest {
        private LottoChecker lottoChecker;
        @BeforeAll
        void initChecker() {
            List<Integer> winningMainNumbers = List.of(1, 2, 3, 4, 5, 6);
            int winningBonusNumber = 7;
            WinningNumbers winningNumbers = new WinningNumbersImpl(winningMainNumbers, winningBonusNumber);
            lottoChecker = new LottoCheckerImpl(winningNumbers);

        }
        @Test
        void null_test() {
            //given
            List<Integer> numbers = null;
            //when
            Throwable throwable = catchThrowable(() -> {
                    int[] result = lottoChecker.checkHowManyMatches(numbers);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 메인_보너스_맞춘_경우_test() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 7, 11, 12);
            //when
            int[] actual = lottoChecker.checkHowManyMatches(numbers);
            //then
            assertThat(actual)
                    .containsExactly(new int[] {3, 1});
        }
        @Test
        void 메인_맞춘_경우_test() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 45, 11, 12);
            //when
            int[] actual = lottoChecker.checkHowManyMatches(numbers);
            //then
            assertThat(actual)
                    .containsExactly(new int[] {3, 0});
        }
        @Test
        void 보너스_맞춘_경우_test() {
            //given
            List<Integer> numbers = List.of(10, 20, 30, 7, 11, 12);
            //when
            int[] actual = lottoChecker.checkHowManyMatches(numbers);
            //then
            assertThat(actual)
                    .containsExactly(new int[] {0, 1});
        }
        @Test
        void 못_맞춘_경우_test() {
            //given
            List<Integer> numbers = List.of(10, 20, 30, 9, 11, 12);
            //when
            int[] actual = lottoChecker.checkHowManyMatches(numbers);
            //then
            assertThat(actual)
                    .containsExactly(new int[] {0, 0});
        }
    }
}
