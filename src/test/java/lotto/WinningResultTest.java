package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest{
    @DisplayName("당첨 결과 일치 테스트")
    @Test
    void createWinningResult() {
        int testTicketAmount = 1;
        Lotto testLotto = new Lotto(List.of(1,2,3,4,5,7));
        List<Lotto> testLottos = new ArrayList<>(List.of(testLotto));
        Lotto testLuckySix = new Lotto(List.of(1,2,3,4,5,6));
        int testLuckyBonus = 7;
        List<Integer> expectedWinningResult = new ArrayList<>(List.of(0,0,0,1,0));

        WinningResult testWinningResult = new WinningResult(testTicketAmount, testLottos, testLuckySix, testLuckyBonus);
        assertThat(testWinningResult.winningResult).isEqualTo(expectedWinningResult);
    }
}