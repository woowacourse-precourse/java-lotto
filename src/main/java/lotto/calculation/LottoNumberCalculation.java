package lotto.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoNumberCalculation {
    public static List<List<Integer>> putTicket(int purchaseCount) {
        List<List<Integer>> multipleTickets = new ArrayList<>();
        for (int tickets = 1; tickets <= purchaseCount; tickets++) {
            multipleTickets.add(getAutomaticLotto());
        }//for
        return multipleTickets;
    }//putTicket

    private static List<Integer> getAutomaticLotto() {
        int ordinalNumber = 6;
        int startNum = 1;
        int endNum = 45;
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(startNum, endNum, ordinalNumber));
        return lotto.getLottoNumbers();
    }// getAutomaticLotto
}// end class
