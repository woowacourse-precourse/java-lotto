package lotto.domain;

public enum PrizeMoney {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    LOSING(0, "0");

    private int countOfMatch;
    private String money;
    private static final int FIRST_MATCH_COUNT = 6;
    private static final int SECOND_MATCH_COUNT = 5;
    private static final int THIRD_MATCH_COUNT = 5;
    private static final int FOURTH_MATCH_COUNT = 4;
    private static final int FIFTH_MATCH_COUNT = 3;

    PrizeMoney(int countOfMatch, String money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    public static PrizeMoney valueOf(int countOfMatch, Boolean matchBonusNumber) {
        if (countOfMatch == FIRST_MATCH_COUNT) {
            return FIRST;
        }
        if (countOfMatch == SECOND_MATCH_COUNT && matchBonusNumber) {
            return SECOND;
        }
        if (countOfMatch == THIRD_MATCH_COUNT) {
            return THIRD;
        }
        if (countOfMatch == FOURTH_MATCH_COUNT) {
            return FOURTH;
        }
        if (countOfMatch == FIFTH_MATCH_COUNT) {
            return FIFTH;
        }
        return LOSING;
    }

    public String getMoney() {
        return money;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}