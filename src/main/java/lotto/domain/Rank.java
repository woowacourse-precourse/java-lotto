package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST("6개 일치 ", "(2,000,000,000원)"),
    SECOND("5개 일치, 보너스 볼 일치 ", "(30,000,000원)"),
    THIRD("5개 일치 ", "(1,500,000원)"),
    FOURTH("4개 일치 ", "(50,000원)"),
    FIFTH("3개 일치 ", "(5,000원)"),
    NOTHING("3개 미만 일치 ", "(0원)");



    private String matchCount;
    private String winnings;

    Rank(String matchCount, String winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public void printRank(int count) {
        System.out.println(matchCount + winnings + " - " + count + "개");
    }
    public static List<Rank> getLottoRanksDesc() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
