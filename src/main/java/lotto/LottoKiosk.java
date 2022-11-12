package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoKiosk {
    static protected List<Integer> winningNumbers;
    static protected int winningBonusNumber;
    static protected List<Integer> resultStatistics =
            new ArrayList<Integer>(PrizeRank.values().length);
}
