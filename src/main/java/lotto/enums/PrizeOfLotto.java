package lotto.enums;

import java.text.DecimalFormat;
import java.util.Map;

public enum PrizeOfLotto {
    FIRST("6개 일치", "1st", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", "2nd", 30_000_000),
    THIRD("5개 일치", "3rd", 1_500_000),
    FOURTH("4개 일치", "4th", 50_000),
    FIFTH("3개 일치", "5th", 5_000);

    private final String criteria;
    private final String rank;
    public String getRank() {
        return rank;
    }
    private final int prize;
    public int getPrize() {
        return prize;
    }
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    PrizeOfLotto(String criteria, String rank, int prize) {
        this.criteria = criteria;
        this.rank = rank;
        this.prize = prize;
    }

    public void announce(Map<String, Integer> resultOfLottos) {
        System.out.println(criteria + " (" + decimalFormat.format(prize) + "원) - " + resultOfLottos.get(rank) + "개");
    }

}
