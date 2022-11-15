package lotto.domain;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultTest {


    Lotto testLotto = new Lotto(List.of(7, 11, 16, 35, 36, 44));
    WinNumbers testWinNumbers = new WinNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)),7);
    LottoResult testLottoResult = new LottoResult(testWinNumbers, List.of(testLotto, testLotto));

    @DisplayName("로또 번호에서 보너스 번호 존재하는지 확인")
    @Test
    void checkResultRank() {
        assertThat(testLottoResult.calculateRank(testWinNumbers, testLotto)).isEqualTo(Rank.OUT);
    }

}