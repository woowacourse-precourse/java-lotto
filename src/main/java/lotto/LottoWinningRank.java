package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinningRank {
    NO_RANK(0, List.of(0L, 1L, 2L), "0"),
    FIRST(1, List.of(6L), "2,000,000,000"),
    SECOND(2, List.of(5L), "30,000,000"),
    THIRD(3, List.of(5L), "1,500,000"),
    FOURTH(4, List.of(4L), "50,000"),
    FIFTH(5, List.of(3L), "5,000");

    private static final int LOTTO_WINNING_RANK_INDEX = 0;

    private final int rank;
    private final List<Long> purchaseNumbersMatchWinningNumbersCounts;
    private final String winningMoney;

    LottoWinningRank(int rank, List<Long> purchaseNumbersMatchWinningNumbersCount, String winningMoney) {
        this.rank = rank;
        this.purchaseNumbersMatchWinningNumbersCounts = purchaseNumbersMatchWinningNumbersCount;
        this.winningMoney = winningMoney;
    }

    public static LottoWinningRank decideLottoWinningRank(long purchaseNumbersMatchWinningNumbersCount,
                                                          boolean isPurchaseNumbersMatchBonusNumber) {
        List<LottoWinningRank> lottoWinningRanks = Arrays.stream(LottoWinningRank.values())
                .filter(lottoWinningRank ->
                        lottoWinningRank.getPurchaseNumbersMatchWinningNumbersCounts()
                                .contains(purchaseNumbersMatchWinningNumbersCount))
                .collect(Collectors.toList());
        // 2등, 3등에 대해서만 보너스 번호 일치/불일치 판단
        if (lottoWinningRanks.contains(SECOND) && lottoWinningRanks.contains(THIRD)) {
            decideLottoWinningRankSecondOrThird(isPurchaseNumbersMatchBonusNumber, lottoWinningRanks);
        }
        return lottoWinningRanks.get(LOTTO_WINNING_RANK_INDEX);
    }

    private static void decideLottoWinningRankSecondOrThird(boolean isPurchaseNumbersMatchBonusNumber,
                                                            List<LottoWinningRank> lottoWinningRanks) {
        if (isPurchaseNumbersMatchBonusNumber) {
            lottoWinningRanks.remove(THIRD);
        }
        if (!isPurchaseNumbersMatchBonusNumber) {
            lottoWinningRanks.remove(SECOND);
        }
    }

    public int getRank() {
        return rank;
    }

    public List<Long> getPurchaseNumbersMatchWinningNumbersCounts() {
        return purchaseNumbersMatchWinningNumbersCounts;
    }


    public String getWinningMoney() {
        return winningMoney;
    }
}
