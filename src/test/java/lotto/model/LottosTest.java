package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 정답과 보너스 볼을 입력하면 등수를 반환를 반환한다.")
    @Test
    void getResult() {
        Lotto winningNumbers = new Lotto("1,2,3,4,5,6");
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto("1,2,3,4,5,6"),
                        new Lotto("1,2,3,4,5,7"),
                        new Lotto("11,2,3,4,5,6"),
                        new Lotto("11,12,3,4,5,6"),
                        new Lotto("11,12,13,4,5,6"),
                        new Lotto("11,12,13,14,5,6"),
                        new Lotto("11,12,13,14,15,16")
                )
        );

        LottoResult result = lottos.getResult(winningNumbers, LottoNumber.of(7));

        assertThat(result.getRanks()).isEqualTo(List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NONE, Rank.NONE));
    }
}
