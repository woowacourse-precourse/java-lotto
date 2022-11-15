package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;

import java.util.Map;

public enum LottoReference {
    THREE(3, 5_000, ""),
    FOUR(4, 50_000, ""),
    FIVE(5, 1_500_000, ""),
    BONUS(5, 30_000_000, ", 보너스 볼 일치"),
    SIX(6, 2_000_000_000, ""),
    NOPE(0, 0, "");
    private final int prize;
    private final int correctCount;
    private final String message;

    LottoReference(int correctCount, int prize, String message) {
        this.prize = prize;
        this.correctCount = correctCount;
        this.message = message;
    }

    public static LottoReference hasCorrectCount(int correctCount) {
        for (LottoReference lottoReference : LottoReference.values()) {
            if (lottoReference.getCorrectCount() == correctCount) {
                return lottoReference;
            }
        }
        return NOPE;
    }

    public static float getYield(Map<LottoReference, Integer> result) {
        int totalTickets = countTickets(result);
        long amountPaid = (long) totalTickets * LOTTO_PRICE;
        long totalPrize = getPrizeByResult(result);

        return (float) totalPrize / amountPaid * 100;
    }

    private static int countTickets(Map<LottoReference, Integer> result) {
        int totalTickets = 0;
        for (int tickets : result.values()) {
            totalTickets += tickets;
        }
        return totalTickets;
    }

    private static long getPrizeByResult(Map<LottoReference, Integer> result) {
        long totalPrize = 0L;
        for (LottoReference lo : LottoReference.values()) {
            if (lo == NOPE) {
                continue;
            }
            totalPrize += (long) lo.getPrize() * result.getOrDefault(lo, 0);
        }
        return totalPrize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public String getMessage() {
        return message;
    }
}
