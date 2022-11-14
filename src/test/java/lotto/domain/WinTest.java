package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinTest {
    private List<Lotto> lotto = Collections.EMPTY_LIST;
    private Ticket ticket;

    @BeforeEach
    public void setup() {
        lotto = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(3, 10, 24, 37, 43, 45)));
        ticket = new Ticket(2, lotto);
    }

    @DisplayName("구매한 로또의 당첨 비교 결과를 생성한다.")
    @Test
    public void createWin() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Win win = new Win();
        win.compareAllLotto(ticket, winningNumbers, bonusNumber);
        assertThat(win).isInstanceOf(Win.class);
    }

    @DisplayName("전체 당첨금을 계산한다.")
    @Test
    public void getWinnings() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int money = Rank.FIRST.getWinnings();
        Win win = new Win();
        win.compareAllLotto(ticket, winningNumbers, bonusNumber);
        assertThat(win.getWinnings()).isEqualTo(money);
    }
}