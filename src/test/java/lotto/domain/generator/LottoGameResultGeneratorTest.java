package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.FIFTH;

public class LottoGameResultGeneratorTest {
    private LottoGameResultGenerator lottoGameResultGenerator = new LottoGameResultGenerator();

    @DisplayName("로또와 당첨번호에서 겹치는 수의 개수를 잘 세는지 테스트")
    @Nested
    class WinningCountCalculatingTest {
        private Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        @DisplayName("당첨번호가 하나도 안 겹치는 경우")
        @Test
        void case1() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 8, 9, 10, 11, 12));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(0);
        }

        @DisplayName("당첨번호가 하나만 겹치는 경우")
        @Test
        void case2() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 11));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(1);
        }
        @DisplayName("당첨번호가 두 개 겹치는 경우")
        @Test
        void case3() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(5, 6, 7, 8, 9, 10));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(2);
        }

        @DisplayName("당첨번호가 세 개 겹치는 경우")
        @Test
        void case4() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 9));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(3);
        }

        @DisplayName("당첨번호가 네 개 겹치는 경우")
        @Test
        void case5() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(3, 4, 5, 6, 7, 8));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(4);
        }

        @DisplayName("당첨번호가 다섯 개 겹치는 경우")
        @Test
        void case6() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 5, 6, 7));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(5);
        }

        @DisplayName("당첨번호가 여섯 개 겹치는 경우")
        @Test
        void case7() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(6);
        }
    }

    @DisplayName("겹치는 수의 개수로 얻는 상금을 잘 구하는지 테스트")
    @Nested
    class PrizeMoneyGettingTest {
       private WinningNumbers winningNumbers;

        @BeforeEach
        void initWinningNumbers() {
            winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            winningNumbers.registerBonusNumber(7);
        }

        @DisplayName("6개가 일치할 때 1등상금을 가져오는지 테스트")
        @Test
        void case1() {
             Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
             int winningCount = 6;

             int prizeMoney = lottoGameResultGenerator.
                     getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);

             assertThat(prizeMoney).isEqualTo(FIRST.prizeMoney());
        }

        @DisplayName("5개가 일치하고 보너스번호가 일치할 때 2등상금을 가져오는지 테스트")
        @Test
        void case2() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            int winningCount = 5;

            int prizeMoney = lottoGameResultGenerator.
                    getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);

            assertThat(prizeMoney).isEqualTo(SECOND.prizeMoney());
        }

        @DisplayName("5개가 일치하지만 보너스번호가 불일치할 때 3등상금을 가져오는지 테스트")
        @Test
        void case3() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
            int winningCount = 5;

            int prizeMoney = lottoGameResultGenerator.
                    getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);

            assertThat(prizeMoney).isEqualTo(THIRD.prizeMoney());
        }

        @DisplayName("4개가 일치할 때 4등상금을 가져오는지 테스트")
        @Test
        void case4() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
            int winningCount = 4;

            int prizeMoney = lottoGameResultGenerator.
                    getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);

            assertThat(prizeMoney).isEqualTo(FOURTH.prizeMoney());
        }

        @DisplayName("3개가 일치할 때 5등상금을 가져오는지 테스트")
        @Test
        void case5() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
            int winningCount = 3;

            int prizeMoney = lottoGameResultGenerator.
                    getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);

            assertThat(prizeMoney).isEqualTo(FIFTH.prizeMoney());
        }
    }

    @DisplayName("겹치는 수로 얻는 상금에 대한 당첨내역 갱신이 잘 되는지 테스트")
    @Nested
    class WinningDetailsUpdatingTest {
        private List<Lotto> lottos = new ArrayList<>();

        @BeforeEach
        void initialize() {
            lottoGameResultGenerator = new LottoGameResultGenerator();
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            lottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
            lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
            lottos.add(new Lotto(List.of(20, 21, 22, 23, 24, 25)));
        }

        @DisplayName("5등 2번한 경우")
        @Test
        void case1() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 10, 11, 12));
            winningNumbers.registerBonusNumber(7);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FIFTH.prizeMoney())).isEqualTo(2);
        }

        @DisplayName("5등 1번, 4등 1번한 경우")
        @Test
        void case2() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 29));
            winningNumbers.registerBonusNumber(1);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FIFTH.prizeMoney())).isEqualTo(1);
            assertThat(winningDetails.get(FOURTH.prizeMoney())).isEqualTo(1);
        }

        @DisplayName("5등 2번, 2등 1번한 경우")
        @Test
        void case3() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 9));
            winningNumbers.registerBonusNumber(10);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FIFTH.prizeMoney())).isEqualTo(2);
            assertThat(winningDetails.get(SECOND.prizeMoney())).isEqualTo(1);
        }

        @DisplayName("4등 1번, 3등 1번한 경우")
        @Test
        void case4() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 15));
            winningNumbers.registerBonusNumber(1);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FOURTH.prizeMoney())).isEqualTo(1);
            assertThat(winningDetails.get(THIRD.prizeMoney())).isEqualTo(1);
        }

        @DisplayName("3등 1번, 2등 1번한 경우")
        @Test
        void case5() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 11));
            winningNumbers.registerBonusNumber(12);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(THIRD.prizeMoney())).isEqualTo(1);
            assertThat(winningDetails.get(SECOND.prizeMoney())).isEqualTo(1);
        }

        @DisplayName("4등 1번, 1등 1번한 경우")
        @Test
        void case6() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 8, 9, 10, 11, 12));
            winningNumbers.registerBonusNumber(40);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FOURTH.prizeMoney())).isEqualTo(1);
            assertThat(winningDetails.get(FIRST.prizeMoney())).isEqualTo(1);
        }

        @DisplayName("1등 1번한 경우")
        @Test
        void case7() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(20, 21, 22, 23, 24, 25));
            winningNumbers.registerBonusNumber(12);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 4000);
            Map<Integer, Integer> winningDetails = lottoGameResult.getWinningDetails();

            assertThat(winningDetails.get(FIRST.prizeMoney())).isEqualTo(1);
        }
    }

    @DisplayName("총 수익금 잘 계산하는지 테스트")
    @Nested
    class ProfitsCalculatingTest {
        private List<Lotto> lottos = new ArrayList<>();

        @BeforeEach
        void initialize() {
            lottoGameResultGenerator = new LottoGameResultGenerator();
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            lottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
            lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
            lottos.add(new Lotto(List.of(20, 21, 22, 23, 24, 25)));
        }

        @DisplayName("5등 2번한 경우")
        @Test
        void case1() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 10, 11, 12));
            winningNumbers.registerBonusNumber(7);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(2 * FIFTH.prizeMoney());
        }

        @DisplayName("5등 1번, 4등 1번한 경우")
        @Test
        void case2() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 29));
            winningNumbers.registerBonusNumber(1);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(FIFTH.prizeMoney() + FOURTH.prizeMoney());
        }

        @DisplayName("5등 2번, 2등 1번한 경우")
        @Test
        void case3() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 9));
            winningNumbers.registerBonusNumber(10);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(2 * FIFTH.prizeMoney() + SECOND.prizeMoney());
        }

        @DisplayName("4등 1번, 3등 1번한 경우")
        @Test
        void case4() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 15));
            winningNumbers.registerBonusNumber(1);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(FOURTH.prizeMoney() + THIRD.prizeMoney());
        }

        @DisplayName("3등 1번, 2등 1번한 경우")
        @Test
        void case5() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 11));
            winningNumbers.registerBonusNumber(12);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(THIRD.prizeMoney() + SECOND.prizeMoney());
        }

        @DisplayName("4등 1번, 1등 1번한 경우")
        @Test
        void case6() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 8, 9, 10, 11, 12));
            winningNumbers.registerBonusNumber(40);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(FOURTH.prizeMoney() + FIRST.prizeMoney());
        }

        @DisplayName("1등 1번한 경우")
        @Test
        void case7() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(20, 21, 22, 23, 24, 25));
            winningNumbers.registerBonusNumber(12);

            lottoGameResultGenerator.calculateWinningDetails(lottos, winningNumbers);
            long profits = lottoGameResultGenerator.calculateProfits();

            assertThat(profits).isEqualTo(FIRST.prizeMoney());
        }
    }

    @DisplayName("수익률 잘 계산하는지 테스트")
    @Nested
    class EarningRateCalculatingTest {
        private List<Lotto> lottos = new ArrayList<>();

        @BeforeEach
        void initialize() {
            lottoGameResultGenerator = new LottoGameResultGenerator();
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            lottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
            lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        }

        @DisplayName("5등 2번한 경우")
        @Test
        void case1() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 10, 11, 12));
            winningNumbers.registerBonusNumber(7);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 3000);
            double earningRate = lottoGameResult.getEarningRate();
            String roundedEarningRate = String.format("%.1f", earningRate);

            assertThat(roundedEarningRate).isEqualTo("333.3");
        }

        @DisplayName("5등 1번, 4등 1번한 경우")
        @Test
        void case2() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 29));
            winningNumbers.registerBonusNumber(1);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 3000);
            double earningRate = lottoGameResult.getEarningRate();
            String roundedEarningRate = String.format("%.1f", earningRate);

            assertThat(roundedEarningRate).isEqualTo("1833.3");
        }

        @DisplayName("5등 2번, 2등 1번한 경우")
        @Test
        void case3() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 9));
            winningNumbers.registerBonusNumber(10);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 3000);
            double earningRate = lottoGameResult.getEarningRate();
            String roundedEarningRate = String.format("%.1f", earningRate);

            assertThat(roundedEarningRate).isEqualTo("1000333.3");
        }

        @DisplayName("5등 1번한 경우")
        @Test
        void case4() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(10, 11, 12, 13, 14, 15));
            winningNumbers.registerBonusNumber(16);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 3000);
            double earningRate = lottoGameResult.getEarningRate();
            String roundedEarningRate = String.format("%.1f", earningRate);

            assertThat(roundedEarningRate).isEqualTo("166.7");
        }

        @DisplayName("4등 1번, 1등 1번한 경우")
        @Test
        void case5() {
            WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 8, 9, 10, 11, 12));
            winningNumbers.registerBonusNumber(16);

            LottoGameResult lottoGameResult = lottoGameResultGenerator.
                    generateLottoGameResult(lottos, winningNumbers, 3000);
            double earningRate = lottoGameResult.getEarningRate();
            String roundedEarningRate = String.format("%.1f", earningRate);

            assertThat(roundedEarningRate).isEqualTo("66668333.3");
        }
    }
}
