package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class IssuedLottoTest {
    @Test
    @DisplayName("로또 결과값 확인")
    void getLottoResult(){
        IssuedLotto issuedLotto = new IssuedLotto(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(2, 4, 6, 8, 10, 12)),
                        new Lotto(List.of(11, 13, 15, 17, 19, 21))
                )
        );

        List<Integer> basicNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningResult result = issuedLotto.compare(basicNumbers, bonusNumber);

        assertThat(result.getWinningCount(FIRST)).isEqualTo(1);
        assertThat(result.getWinningCount(SECOND)).isEqualTo(1);
        assertThat(result.getWinningCount(THIRD)).isEqualTo(0);
        assertThat(result.getWinningCount(FOURTH)).isEqualTo(0);
        assertThat(result.getWinningCount(FIFTH)).isEqualTo(1);
    }
}