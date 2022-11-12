package lotto.lottocomparator;

import lotto.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.lottocomparator.LottoComparator.judgeAllLotto;
import static lotto.lottocomparator.LottoComparator.judgeWinning;
import static lotto.lottocomparator.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;

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
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, -1));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(FIRST);
    }

    /**
     * 2등인 경우
     */
    @Test
    void judgeSecondTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7, -1));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(SECOND);
    }

    /**
     * 3등인 경우
     */
    @Test
    void judgeThirdTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8, -1));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(THIRD);
    }

    /**
     * 4등인 경우
     */
    @Test
    void judgeFourthTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(FOURTH);
    }

    /**
     * 5등인 경우
     */
    @Test
    void judgeFifthTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 3, 8, 9, 10, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(FIFTH);
    }

    /**
     * 꽝인 경우
     */
    @Test
    void judgeLosingTicketTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoNumber userLotto = new LottoNumber(Arrays.asList(1, 2, 8, 9, 10, 11, 7));
        WinningRank rank = judgeWinning(winningLotto, userLotto);
        assertThat(rank).isEqualTo(LOSING_TICKET);
    }

    /**
     * 여러 개의 로또를 모두 비교하여 총 결과를 반환하는 테스트입니다.
     */
    @Test
    void judgeAllLottoTest() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<LottoNumber> userLotto = new ArrayList<>();
        userLotto.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        userLotto.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7, -1)));

        WinningLotto result = judgeAllLotto(winningLotto, userLotto);
        assertThat(result.getTotalReward()).isEqualTo(2030000000);
        assertThat(result.getWinningNumbers().get(0)).isEqualTo(1);
        assertThat(result.getWinningNumbers().get(1)).isEqualTo(1);
    }
}