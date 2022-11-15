package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    public int price = 5000;
    public List<Lotto> lottoList = new ArrayList<>(
            List.of(
                    new Lotto(List.of(6, 4, 5, 3, 2, 1)),
                    new Lotto(List.of(16, 32, 11, 38, 3, 5)),
                    new Lotto(List.of(11, 16, 7, 35, 36, 44)),
                    new Lotto(List.of(8, 31, 41, 1, 42, 11)),
                    new Lotto(List.of(16, 38, 42, 14, 45, 13))

            )
    );
    public List<Integer> winningNumbers = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
    public int bonusNumber = 3;

    @DisplayName("로또 당첨 판별결과 5등 당첨이다.")
    @Test
    void getRankFifth() {
        LottoGame lottoGame = new LottoGame(this.price, this.lottoList, this.winningNumbers, this.bonusNumber);
        Rank rank = lottoGame.getRank(this.lottoList.get(0));

        assertThat(Rank.Fifth).isEqualTo(rank);
    }

    @DisplayName("로또 당첨 판별결과 2등 당첨이다.")
    @Test
    void getRankSecond() {
        LottoGame lottoGame = new LottoGame(this.price, this.lottoList, this.winningNumbers, this.bonusNumber);
        Rank rank = lottoGame.getRank(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        assertThat(Rank.Second).isEqualTo(rank);
    }

    @DisplayName("로또 당첨 결과의 내역을 구한다.")
    @Test
    void getStatistic() {
        LottoGame lottoGame = new LottoGame(this.price, this.lottoList, this.winningNumbers, this.bonusNumber);
        List<Rank> statistic = lottoGame.getStatistics();
        List<Rank> expectStatistic = new ArrayList<>(List.of(Rank.Fifth));

        assertThat(statistic).isEqualTo(expectStatistic);
    }
    @DisplayName("수익률을 구한다")
    @Test
    void getEarnPriceRate(){
        LottoGame lottoGame = new LottoGame(this.price, this.lottoList, this.winningNumbers, this.bonusNumber);
        double rate = lottoGame.getEarnPriceRate();
        assertThat(rate).isEqualTo(100);
    }
    @DisplayName("로또 발행 내역을 오름차순 정렬한다.")
    @Test
    void getSortedLottoList() {
        LottoGame lottoGame = new LottoGame(this.price, this.lottoList, this.winningNumbers, this.bonusNumber);

        List<List<Integer>> expectLottoList = new ArrayList<>();
        expectLottoList.add(List.of(1, 2, 3, 4, 5, 6));
        expectLottoList.add(List.of(3, 5, 11, 16, 32, 38));
        expectLottoList.add(List.of(7, 11, 16, 35, 36, 44));
        expectLottoList.add(List.of(1, 8, 11, 31, 41, 42));
        expectLottoList.add(List.of(13, 14, 16, 38, 42, 45));

        List<List<Integer>> lottoList = new ArrayList<>();

        List<Lotto> sortedLottoList = lottoGame.getSortedLottoList();
        for (Lotto lotto : sortedLottoList) {

            lottoList.add(lotto.getNumbers());
        }
        assertThat(lottoList).isEqualTo(expectLottoList);
    }
}
