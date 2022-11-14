package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    @DisplayName("로또 번호와 당첨번호가 일치하는 개수 카운트하는 기능 테스트")
    @Test
    void checkCountMatch() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningNumber = new Lotto(List.of(1,3,5,7,9,11));
        int result = 3;
        assertThat(LottoMatch.countMatch(lotto, winningNumber)).isEqualTo(result);
    }


}
