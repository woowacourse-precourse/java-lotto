package lotto.calculation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    public static Map<String, Integer> calculateStatistics(
            List<List<Integer>> multipleTickets, List<Integer> winningNumber, Integer bonusNumber) {

        Map<String, Integer> statistics = new HashMap<>();
        for (int rank = 1; rank < 6; rank++) {
            statistics.put(rank + "등", 0);
        }//for

        for (List<Integer> LottoTicket : multipleTickets) {
            String rank = rankCheck(LottoTicket, winningNumber, bonusNumber);
            if (rank != "") {
                statistics.put(rank, statistics.get(rank) + 1);
            }//if
        }//for
        return statistics;
    }//calculateStatistics

    static String rankCheck(
            List<Integer> LottoTicket, List<Integer> winningNumber, Integer bonusNumber) {

        int sameNumberCount = 0;
        String rank = "";
        int bonusSame = Collections.frequency(LottoTicket, bonusNumber);

        for (Integer number : winningNumber) {
            if (1 == Collections.frequency(LottoTicket, number)) {sameNumberCount++;}
        }//for

        if (sameNumberCount == 3) {rank = "5등";}
        if (sameNumberCount == 4) {rank = "4등";}
        if (sameNumberCount == 5 && 0 == bonusSame) {rank = "3등";}
        if (sameNumberCount == 5 && 1 == bonusSame) {rank = "2등";}
        if (sameNumberCount == 6) {rank = "1등";}
        return rank;
    }//rankCheck
}// end class
