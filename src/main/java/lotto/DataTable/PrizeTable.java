package lotto.DataTable;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;

public enum PrizeTable {
    FirstPlace(6, 2000000000),
    SecondPlace(5, 30000000),
    SecondPlaceBonus(0, 30000000),
    ThirdPlace(4, 50000),
    FourthPlace(3, 5000);

    public final int prize;
    public final int count;
    public static final Map<Integer, Integer> AMOUNT_BY_RANK = new HashMap<Integer, Integer>();

    private PrizeTable(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }


    static {
        for (PrizeTable prizeTable : values()) {
            AMOUNT_BY_RANK.put(prizeTable.count, prizeTable.prize);
        }
    }


    public static Map<Integer, Integer> setScoreTable() {
        Map<Integer, Integer> map = new HashMap<>();
        for (PrizeTable p : values()) {
            map.put(p.count, 0);
        }
        return map;
    }


    public static Integer valueOfPrize(int count) {
        return AMOUNT_BY_RANK.get(count);
    }
}
