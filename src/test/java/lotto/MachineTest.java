package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("일치하는 번호 개수 확인 - 모두 일치 하는 경우")
    @Test
    void compareLottoCorrectAll() {
        int count = machine.compare(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(count).isEqualTo(6);
    }

    @DisplayName("일치하는 번호 개수 확인 - 하나만 일치 하는 경우")
    @Test
    void compareLottoCorrectOne() {
        int count = machine.compare(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(6, 7, 8, 9, 10, 11)));

        Assertions.assertThat(count).isEqualTo(1);
    }

    @DisplayName("순위 확인 - 1등")
    @Test
    void rankingCheckFirst() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank ranking = machine.Ranking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.FIRST);
    }

    @DisplayName("순위 확인 - 2등")
    @Test
    void rankingCheckSecond() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank ranking = machine.Ranking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.SECOND);
    }


    @DisplayName("순위 확인 - 3등")
    @Test
    void rankingCheckTHIRD() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Rank ranking = machine.Ranking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.THIRD);
    }


    @DisplayName("순위 확인 - 미당첨")
    @Test
    void rankingCheckLose() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Rank ranking = machine.Ranking(winningNumber, lotto);
        Assertions.assertThat(ranking).isEqualTo(Rank.LOSE);
    }

}

