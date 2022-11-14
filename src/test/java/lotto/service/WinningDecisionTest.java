package lotto.service;

import lotto.entity.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningDecisionTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
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

    @BeforeEach
    void setOutStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    @DisplayName("map에 몇 등을 몇 번했는지 저장한다.")
    void winningPrizesTest() {
        // when
        winningDecision.setMyPrizes();

        // then
        Map<Integer, Integer> winningPrizes = winningDecision.getWinningPrizes();
        assertEquals(3, winningPrizes.get(WinningResult.MATCH_THREE.getPrize()));
    }
}
