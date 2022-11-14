package lotto;

public enum Prize {
    FIRST(1, "6개 일치", 2000000000000L),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(5, "3개 일치", 5000);

    final int grade;
    final String description;
    final long cashPrize;

    Prize(int grade, String description, long cashPrize) {
        this.grade = grade;
        this.description = description;
        this.cashPrize = cashPrize;
    }
}
