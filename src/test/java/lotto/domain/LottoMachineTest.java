package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final User user = new User();

    @BeforeEach
    void issueLotto() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        user.receive(List.of(new Lotto(numbers)));
    }

    @DisplayName("6개 숫자가 모두 일치하면 1등 당첨")
    @Test
    void sixHit() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Bonus bonus = new Bonus(7);
        assertThat(lottoMachine.determineWinners(user, winningLotto, bonus))
                .isEqualTo(new int[] {0, 1, 0, 0, 0, 0});
    }

    @DisplayName("5개 숫자와 보너스 번호가 모두 일치하면 2등 당첨")
    @Test
    void fiveHitWithBonus() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,10));
        Bonus bonus = new Bonus(6);
        assertThat(lottoMachine.determineWinners(user, winningLotto, bonus))
                .isEqualTo(new int[] {0, 0, 1, 0, 0, 0});
    }

    @DisplayName("5개 숫자가 일치하면 3등 당첨")
    @Test
    void fiveHit() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,10));
        Bonus bonus = new Bonus(20);
        assertThat(lottoMachine.determineWinners(user, winningLotto, bonus))
                .isEqualTo(new int[] {0, 0, 0, 1, 0, 0});
    }

    @DisplayName("4개 숫자가 일치하면 4등 당첨")
    @Test
    void fourHit() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,10,20));
        Bonus bonus = new Bonus(30);
        assertThat(lottoMachine.determineWinners(user, winningLotto, bonus))
                .isEqualTo(new int[] {0, 0, 0, 0, 1, 0});
    }

    @DisplayName("3개 숫자가 일치하면 5등 당첨")
    @Test
    void threeHit() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,10,20,30));
        Bonus bonus = new Bonus(40);
        assertThat(lottoMachine.determineWinners(user, winningLotto, bonus))
                .isEqualTo(new int[] {0, 0, 0, 0, 0, 1});
    }
}
