package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static List<Lotto> lottoTickets = new ArrayList<>();
    private static List<Integer> lottoResults = new ArrayList<>();

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static int getLottoTicketsSize() {
        return lottoTickets.size();
    }

    public static List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public static void setLottoResults(List<Integer> lottoResults) {
        LottoTickets.lottoResults = lottoResults;
    }

    public static List<Integer> getLottoResults() {
        return lottoResults;
    }

    public static int getPurchaseAmount() {
        return getLottoTicketsSize() * ReferenceValue.LOTTO_PRICE;
    }

    public static double getTotalReturn() {

        int purchaseAmount = getPurchaseAmount();
        int winningAmounts = getWinningAmounts();

        double totalReturn = Math.round((winningAmounts / purchaseAmount) * ReferenceValue.MULTIPLE_FIRST_DECIMAL) / ReferenceValue.DIVIDE_FIRST_DECIMAL;

        return totalReturn;
    }

    public static int getWinningAmounts() {
        int sum = 0;

        for (int result : lottoResults) {
            sum += getMatchesMoney(result);
        }

        return sum;
    }

    public static int getMatchesMoney(Integer index) {
        int money = 0;

        if (index == ReferenceValue.THREE_MATCHES_INDEX) {
            money = ReferenceValue.THREE_MATCHES_MONEY;
        } else if (index == ReferenceValue.FOUR_MATCHES_INDEX) {
            money = ReferenceValue.FOUR_MATCHES_MONEY;
        } else if (index == ReferenceValue.FIVE_MATCHES_INDEX) {
            money = ReferenceValue.FIVE_MATCHES_MONEY;
        } else if (index == ReferenceValue.FIVE_BONUS_MATCHES_INDEX) {
            money = ReferenceValue.FIVE_BONUS_MATCHES_MONEY;
        } else if (index == ReferenceValue.SIX_MATCHES_INDEX) {
            money = ReferenceValue.SIX_MATCHES_MONEY;
        }

        return money;
    }
}
