package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinLotto;
import lotto.domain.statistics.Rank;
import lotto.domain.statistics.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    WinLotto winLotto;

    @BeforeEach
    void 로또_생성() {
        winLotto = WinLotto.of(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("로또결과가 1등인경우 경우 ")
    @Test
    void Result_생성_1등_검증_테스트() {
        //given
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = Lottos.of(List.of(lotto));

        //when
        Result result = Result.of(lottos, winLotto);

        //then
        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getPrize()).isEqualTo(2_000_000_000);
    }


    @DisplayName("로또결과가 2등인경우 경우")
    @Test
    void Result_생성_2등_검증_테스트() {
        //given
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lottos lottos = Lottos.of(List.of(lotto));

        //when
        Result result = Result.of(lottos, winLotto);

        //then
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("로또결과가 NOTHING 일경우")
    @Test
    void Result_생성_NOTHING_검증_테스트() {
        //given
        Lotto lotto1 = Lotto.from(Arrays.asList(8, 9, 10, 11, 12, 13));
        Lotto lotto2 = Lotto.from(Arrays.asList(14, 15, 16, 17, 18, 19));
        Lotto lotto3 = Lotto.from(Arrays.asList(20, 21, 22, 23, 24, 25));
        Lottos lottos = Lottos.of(List.of(lotto1,lotto2,lotto3));

        //when
        Result result = Result.of(lottos, winLotto);

        //then
        assertThat(result.getRankCount(Rank.NOTHING)).isEqualTo(3);
        assertThat(result.getPrize()).isEqualTo(0);
    }
}
