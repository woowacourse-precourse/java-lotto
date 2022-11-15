package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningRankTest {

    @Test
    void 몇_등인지_구하기_당첨_개수_0개는_랭크_없음_보너스_번호_일치_불일치는_상관없음() {
        long purchaseNumbersMatchWinningNumbersCount = 0;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank matchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);


        assertThat(matchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_1개는_랭크_없음_보너스_번호_일치_불일치는_상관없음() {
        long purchaseNumbersMatchWinningNumbersCount = 1;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank matchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);


        assertThat(matchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_2개는_랭크_없음_보너스_번호_일치_불일치는_상관없음() {
        long purchaseNumbersMatchWinningNumbersCount = 2;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank matchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);


        assertThat(matchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.NO_RANK);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_3개는_5등_보너스_번호_일치_불일치는_상관없음() {
        long purchaseNumbersMatchWinningNumbersCount = 3;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank matchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);


        assertThat(matchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.FIFTH);
        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.FIFTH);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_4개는_4등_보너스_번호_일치_불일치는_상관없음() {
        long purchaseNumbersMatchWinningNumbersCount = 4;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank matchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);


        assertThat(matchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.FOURTH);
        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.FOURTH);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_5개_보너스_번호_불일치는_3등() {
        long purchaseNumbersMatchWinningNumbersCount = 5;
        boolean isPurchaseNumbersMatchBonusNumberFalse = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberFalse);

        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.THIRD);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_5개_보너스_번호_일치는_2등() {
        long purchaseNumbersMatchWinningNumbersCount = 5;
        boolean isPurchaseNumbersMatchBonusNumberTrue = true;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.SECOND);
    }

    @Test
    void 몇_등인지_구하기_당첨_개수_6개는_1등() {
        long purchaseNumbersMatchWinningNumbersCount = 6;
        boolean isPurchaseNumbersMatchBonusNumberTrue = false;
        LottoWinningRank notMatchBonusNumberLottoWinningRank = LottoWinningRank
                .decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount, isPurchaseNumbersMatchBonusNumberTrue);

        assertThat(notMatchBonusNumberLottoWinningRank).isEqualTo(LottoWinningRank.FIRST);
    }
}