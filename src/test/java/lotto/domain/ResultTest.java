package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    @DisplayName("당첨 번호와 로또 번호가 모두 일치할 경우 1등")
    void testName() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;
        Rank[] values = Rank.values();
        assertThat(values[0].getCount()).isEqualTo(1);
        assertThat(values[1].getCount()).isEqualTo(0);
        assertThat(values[2].getCount()).isEqualTo(0);
        assertThat(values[3].getCount()).isEqualTo(0);
        assertThat(values[4].getCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("당첨 번호와 로또 번호가 5개 그리고 보너스 번호가 일치할 경우 2등")
    void testName2() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;
        Rank[] values = Rank.values();
        assertThat(values[0].getCount()).isEqualTo(0);
        assertThat(values[1].getCount()).isEqualTo(1);
        assertThat(values[2].getCount()).isEqualTo(0);
        assertThat(values[3].getCount()).isEqualTo(0);
        assertThat(values[4].getCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("당첨 번호와 로또 번호가 5개가 일치할 경우 3등")
    void testName3() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;
        Rank[] values = Rank.values();
        assertThat(values[0].getCount()).isEqualTo(0);
        assertThat(values[1].getCount()).isEqualTo(0);
        assertThat(values[2].getCount()).isEqualTo(1);
        assertThat(values[3].getCount()).isEqualTo(0);
        assertThat(values[4].getCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("당첨 번호와 로또 번호가 4개가 일치할 경우 4등")
    void testName4() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 9, 10)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;
        Rank[] values = Rank.values();
        assertThat(values[0].getCount()).isEqualTo(0);
        assertThat(values[1].getCount()).isEqualTo(0);
        assertThat(values[2].getCount()).isEqualTo(0);
        assertThat(values[3].getCount()).isEqualTo(1);
        assertThat(values[4].getCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("당첨 번호와 로또 번호가 3개가 일치할 경우 5등")
    void testName5() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 15, 16)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;
        Rank[] values = Rank.values();
        assertThat(values[0].getCount()).isEqualTo(0);
        assertThat(values[1].getCount()).isEqualTo(0);
        assertThat(values[2].getCount()).isEqualTo(0);
        assertThat(values[3].getCount()).isEqualTo(0);
        assertThat(values[4].getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 8000원을 구매해 5등 1개가 당첨됐을 경우 수익률은 62.5%이다.")
    void getWinningAmount(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 15, 16)));
        int count = (int) lottos.get(0).getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
        boolean contains = lottos.get(0).getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOfRank(count, contains);
        rank.count++;

        Result result = new Result(Rank.values());
        result.initWinningAmount(8000);

        assertThat(String.format("%.1f", result.getWinningAmount())).isEqualTo("62.5");
    }
}