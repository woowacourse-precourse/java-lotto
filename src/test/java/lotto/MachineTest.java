package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MachineTest {

    Machine machine;

    @BeforeEach
    void setUp() {
        machine = new Machine();
    }


    @DisplayName("로또의 개수 확인")
    @Test
    void checkNumCountLotto() {
        Lotto lotto = machine.draw();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("발행한 개수 확인")
    @Test
    void checkDrawCount() {
        int count = 10;
        List<Lotto> lottos = machine.draw(count);
        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("순위 확인 - 1등")
    @Test
    void rankingCheckFirst() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank ranking = machine.checkRanking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.FIRST);
    }

    @DisplayName("순위 확인 - 2등")
    @Test
    void rankingCheckSecond() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank ranking = machine.checkRanking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.SECOND);
    }


    @DisplayName("순위 확인 - 3등")
    @Test
    void rankingCheckTHIRD() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Rank ranking = machine.checkRanking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.THIRD);
    }


    @DisplayName("순위 확인 - 미당첨")
    @Test
    void rankingCheckLose() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Rank ranking = machine.checkRanking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.LOSE);
    }

    @DisplayName("여러개의 로또 맞추기")
    @Test
    void rankingChecks() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto1);
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottos.add(lotto2);
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        lottos.add(lotto3);
        Lotto lotto4 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        lottos.add(lotto4);

        Map<Rank, Integer> ranking = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));
        Assertions.assertThat(ranking.size()).isEqualTo(6);
        Assertions.assertThat(ranking.get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(ranking.get(Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(ranking.get(Rank.THIRD)).isEqualTo(1);
        Assertions.assertThat(ranking.get(Rank.LOSE)).isEqualTo(1);
    }


    @DisplayName("수익률 계산 - 1등")
    @Test
    void calculateYieldRateFirst() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto1);

        Map<Rank, Integer> ranking = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));

        double yieldRate = machine.calculateYieldRate(ranking);
        Assertions.assertThat(yieldRate).isEqualTo(200000000);
    }

    @DisplayName("수익률 계산 - 2등")
    @Test
    void calculateYieldRateSecond() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottos.add(lotto2);

        Map<Rank, Integer> ranking = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));

        double yieldRate = machine.calculateYieldRate(ranking);
        Assertions.assertThat(yieldRate).isEqualTo(3000000);
    }

    @DisplayName("수익률 계산 - 미당첨")
    @Test
    void calculateYieldRateLose() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);
        Lotto lotto2 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        lottos.add(lotto2);

        Map<Rank, Integer> ranking = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));

        double yieldRate = machine.calculateYieldRate(ranking);
        Assertions.assertThat(yieldRate).isEqualTo(0);
    }


    @DisplayName("수익률 계산 - 5등 1개, 미당첨 1개")
    @Test
    void calculateYieldRateFive1Lose1() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lottos.add(lotto1);
        Lotto lotto2 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        lottos.add(lotto2);

        Map<Rank, Integer> ranking = machine.checkRanking(winningNumber, lottos.toArray(new Lotto[0]));

        double yieldRate = machine.calculateYieldRate(ranking);
        Assertions.assertThat(yieldRate).isEqualTo(250);
    }
}



