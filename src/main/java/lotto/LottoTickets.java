package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private static int size;
    private static List<Lotto> lottoTickets = new ArrayList<>();
    private static List<Result> lottoResults = new ArrayList<>();
    private static List<Integer> lottoMatches = new ArrayList<>();

    public LottoTickets(List<Lotto> lottoTickets) {
        this.size = lottoTickets.size();
        this.lottoTickets = lottoTickets;
    }

    public void setLottoResults(List<Result> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public Lotto getLotto(int index) {
        return lottoTickets.get(index);
    }

    public int getLottoTicketsSize() {
        return lottoTickets.size();
    }

    public static List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public Result getLottoResult(int resultIndex) {
        Result result = lottoResults.get(resultIndex);
        return result;
    }

    public double getTotalReturn() {

        double purchaseAmount = (double) getPurchaseAmount();
        double winningAmounts = (double) getWinningAmounts();

        double totalReturn = (winningAmounts / purchaseAmount) * ReferenceValue.MULTIPLE_HUNDRED;
        double totalReturnPercent = Math.round(totalReturn * ReferenceValue.MULTIPLE_FIRST_DECIMAL) / ReferenceValue.DIVIDE_FIRST_DECIMAL;

        return totalReturnPercent;
    }

    private static int getPurchaseAmount() {
        return size * ReferenceValue.LOTTO_PRICE;
    }

    public static int getWinningAmounts() {
        int sum = 0;

        for (int eachMatchIndex : lottoMatches) {
            sum += getMatchesMoney(eachMatchIndex);
        }

        return sum;
    }

    private static int getMatchesMoney(int eachMatchIndex) {

        int money = 0;

        if (eachMatchIndex == ReferenceValue.INDEX_THREE_MATCHES) {
            money = ReferenceValue.MONEY_THREE_MATCHES;
        } else if (eachMatchIndex == ReferenceValue.INDEX_FOUR_MATCHES) {
            money = ReferenceValue.MONEY_FOUR_MATCHES;
        } else if (eachMatchIndex == ReferenceValue.INDEX_FIVE_MATCHES) {
            money = ReferenceValue.MONEY_FIVE_MATCHES;
        } else if (eachMatchIndex == ReferenceValue.INDEX_FIVE_BONUS_MATCHES) {
            money = ReferenceValue.MONEY_FIVE_BONUS_MATCHES;
        } else if (eachMatchIndex == ReferenceValue.INDEX_SIX_MATCHES) {
            money = ReferenceValue.MONEY_SIX_MATCHES;
        }

        return money;
    }
    public static List<Integer> getMatches() {
        return lottoMatches;
    }
    public void setMatches() {

        Map<Integer, Integer> matchesDictionary = inItMatchesDictionary();
        List<Integer> matches;

        for (int resultIndex = 0; resultIndex < size; resultIndex++) {
            Result result = lottoResults.get(resultIndex);
            int matchesIndex = getMatchesIndex(result);
            int matchesCount = matchesDictionary.get(matchesIndex);
            matchesDictionary.replace(matchesIndex, matchesCount + 1);
        }

        matches = new ArrayList<>(matchesDictionary.values());
        lottoMatches = matches;
    }

    private static HashMap<Integer, Integer> inItMatchesDictionary() {

        HashMap<Integer, Integer> matchesDictionary = new HashMap<>();

        matchesDictionary.put(ReferenceValue.INDEX_OTHER_MATCHES, ReferenceValue.NOTHING);
        matchesDictionary.put(ReferenceValue.INDEX_THREE_MATCHES, ReferenceValue.NOTHING);
        matchesDictionary.put(ReferenceValue.INDEX_FOUR_MATCHES, ReferenceValue.NOTHING);
        matchesDictionary.put(ReferenceValue.INDEX_FIVE_MATCHES, ReferenceValue.NOTHING);
        matchesDictionary.put(ReferenceValue.INDEX_FIVE_BONUS_MATCHES, ReferenceValue.NOTHING);
        matchesDictionary.put(ReferenceValue.INDEX_SIX_MATCHES, ReferenceValue.NOTHING);

        return matchesDictionary;
    }

    private static int getMatchesIndex(Result result) {
        int size = result.size();

        int matchesIndex = ReferenceValue.INDEX_OTHER_MATCHES;

        if (size == ReferenceValue.COUNT_THREE_MATCHES) {
            matchesIndex = ReferenceValue.INDEX_THREE_MATCHES;
        } else if (size == ReferenceValue.COUNT_FOUR_MATCHES) {
            matchesIndex = ReferenceValue.INDEX_FOUR_MATCHES;
        } else if (size == ReferenceValue.COUNT_FIVE_MATCHES) {
            matchesIndex = checkBonusIndex(result);
        } else if (size == ReferenceValue.COUNT_SIX_MATCHES) {
            matchesIndex = ReferenceValue.INDEX_SIX_MATCHES;
        }

        return matchesIndex;
    }

    public static int checkBonusIndex(Result result) {
        int matchesIndex = ReferenceValue.INDEX_FIVE_MATCHES;
        boolean isBonus = result.getIsBonus();

        if (isBonus) {
            matchesIndex = ReferenceValue.INDEX_FIVE_BONUS_MATCHES;
        }

        return matchesIndex;
    }
}
