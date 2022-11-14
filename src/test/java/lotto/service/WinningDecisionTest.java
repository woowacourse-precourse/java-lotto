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

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("당첨 내역을 출력한다.")
    void showWinningDecisionTest() {
        // given
        winningDecision.setMyPrizes();

        // when
        winningDecision.showWinningDecision();

        // then
        String expected = "당첨 통계\n" +
                "---\r\n" + // for Windows
                "3개 일치 (5,000원) - 3개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 100.0%입니다.";
        assertThat(output.toString()).isEqualTo(expected);
    }
}
