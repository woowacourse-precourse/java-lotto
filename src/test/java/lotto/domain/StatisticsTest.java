package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {
    List<Integer> winningNumbers;
    int bonusNumber;
    Ticket ticket;
    Answer answer;
    Statistics statistics;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(1000);
        winningNumbers = new ArrayList<>(ticket.getLottos().get(0).getNumbers());
        List<Integer> numbers = anyTwoLottoNumberNotInNumbers(winningNumbers);

        winningNumbers.set(0, numbers.get(0));
        bonusNumber = numbers.get(1);

        answer = new Answer();
        answer.setWinningNumbers(winningNumbers);
        answer.setBonusNumber(bonusNumber);

        statistics = new Statistics(ticket, answer);
    }

    @DisplayName("3등이 1번 나오면 성공한다.")
    @Test
    void getCount() {
        assertThat(statistics.getCount(5, false))
                .isEqualTo(1);
    }

    @DisplayName("로또 1개 구매 후 1개 당첨의 수익률이 나오면 성공한다.")
    @Test
    void getReturnRate() {
        assertThat(statistics.getReturnRate())
                .isEqualTo(1500000 / 1000.0);
    }

    private List<Integer> anyTwoLottoNumberNotInNumbers(List<Integer> sixNumbers) {
        List<Integer> twoNumbers;
        do {
            twoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 2);
        } while (sixNumbers.contains(twoNumbers.get(0)) || sixNumbers.contains(twoNumbers.get(1)));
        return twoNumbers;
    }
}
