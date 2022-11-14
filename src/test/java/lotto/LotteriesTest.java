package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteriesTest {

    @DisplayName("당첨된 갯수 반환 성공")
    @Test
    void test() {
        //given
        List<Integer> winNumberList = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 24;
        WinNumbers winNumbers = new WinNumbers(winNumberList, bonusNumber);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 45, 12, 14));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 8, 24));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 24));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        Lotteries lotteries = new Lotteries(lottoList);

        //when
        LottoResult lottoResult = lotteries.countMatchNumbers(winNumbers);

        //then
        assertThat(lottoResult.getLottoMatchCountByKey(Match.THREE)).isEqualTo(1);
        assertThat(lottoResult.getLottoMatchCountByKey(Match.FOUR)).isEqualTo(1);
        assertThat(lottoResult.getLottoMatchCountByKey(Match.FIVE)).isEqualTo(1);
        assertThat(lottoResult.getLottoMatchCountByKey(Match.FIVE_WITH_BONUS)).isEqualTo(1);
        assertThat(lottoResult.getLottoMatchCountByKey(Match.SIX)).isEqualTo(2);
    }
}
