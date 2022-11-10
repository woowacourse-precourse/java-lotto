package lotto;

import java.util.HashMap;
import java.util.List;

public class Result {
    private static HashMap<MatchCount, Integer> totalMatchResult = new HashMap<>();

    public Result(List<Lotto> lottoTickets) {
        saveMatchResult(lottoTickets);
    }

    public void saveMatchResult(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            MatchCount matchResult = LottoNumber.getMatchResult(lotto);
            totalMatchResult.put(matchResult, totalMatchResult.getOrDefault(matchResult, 0)+1);
        }
    }
}
