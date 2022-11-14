package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    void 상금_총합_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1, lotto2), winningNums);

        long result = 2030000000L;
        assertThat(lottoResult.getTotalPrize()).isEqualTo(result);
    }

    @Test
    void _1등_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(1).isEqualTo(result.get(FIRST));
    }

    @Test
    void _2등_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(1).isEqualTo(result.get(SECOND));
    }

    @Test
    void _3등_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(1).isEqualTo(result.get(THIRD));
    }

    @Test
    void _4등_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(1).isEqualTo(result.get(FOURTH));
    }

    @Test
    void _5등_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 10, 9, 7));
        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(1).isEqualTo(result.get(FIFTH));
    }

    @Test
    void _꽝_당첨_개수_검증() {
        Lotto lotto1 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        Lotto lotto2 = new Lotto(List.of(1, 10, 11, 12, 13, 14));
        Lotto lotto3 = new Lotto(List.of(1, 2, 10, 11, 12, 13));

        WinningNums winningNums = new WinningNums("1, 2, 3, 4, 5, 6", "7");
        LottoResult lottoResult = new LottoResult(List.of(lotto1, lotto2, lotto3), winningNums);
        HashMap<Rank, Integer> result = lottoResult.get();
        assertThat(3).isEqualTo(result.get(LOSE));
    }

}