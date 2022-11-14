package lotto.service;

import lotto.entity.Lotto;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class WinningDecisionTest {
    private WinningDecision winningDecision;

    @BeforeEach
    void construct() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(numbers);

        List<Lotto> myLotto = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> myNumbers = List.of(1, 2, 3, 7, 8, 9);
            Lotto lotto = new Lotto(myNumbers);
            myLotto.add(lotto);
        }
        int bonus = 10;
        int purchaseAmount = 15000;
        winningDecision = new WinningDecision(myLotto, winningLotto, bonus, purchaseAmount);
        winningDecision.initMyPrizes();
    }
}
