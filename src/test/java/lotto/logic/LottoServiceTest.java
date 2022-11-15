package lotto.logic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    static LottoService lottoService;

    @BeforeAll
    static void init() {
        lottoService = LottoService.getInstance();
    }

    @DisplayName("구입한 로또들과 당첨 번호, 보너스 번호를 비교하여, 당첨 등수의 정보를 반환한다.")
    @Test
    void getResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(10, 7, 3, 9, 11, 5))
        );

        Winning target = new Winning(List.of(1, 2, 3, 4, 5, 7), 6);

        Map<Rank, Integer> countOfRank = lottoService.getResult(lottos, target);
        assertThat(countOfRank.get(Rank.SECOND)).isEqualTo(2);
        assertThat(countOfRank.get(Rank.FIFTH)).isEqualTo(1);
    }

}
