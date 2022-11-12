package lotto.lottocomparator;

import lotto.lottonumber.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static lotto.lottocomparator.LottoComparator.judgeWinning;
import static lotto.lottocomparator.WinningRank.*;

/**
 * LottoComparator 클래스에 관련된 테스트 클래스입니다.
 */
class LottoComparatorTest {

    /**
     * 1등인 경우
     */
    @Test
    void judgeFirstTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(FIRST);
    }

    /**
     * 2등인 경우
     */
    @Test
    void judgeSecondTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(SECOND);
    }

    /**
     * 3등인 경우
     */
    @Test
    void judgeThirdTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8, 9));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(THIRD);
    }

    /**
     * 4등인 경우
     */
    @Test
    void judgeFourthTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(FOURTH);
    }

    /**
     * 5등인 경우
     */
    @Test
    void judgeFifthTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 8, 9, 10, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(FIFTH);
    }

    /**
     * 꽝인 경우
     */
    @Test
    void judgeLosingTicketTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 8, 9, 10, 11, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        Assertions.assertThat(rank).isEqualTo(LOSING_TICKET);
    }
}