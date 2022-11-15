package lotto.domain;

public enum Ranking {
    FIRST(2000000000, "2,000,000,000", 6, false),
    SECOND(30000000, "30,000,000", 5, true),
    THIRD(1500000, "1,500,000", 5, false),
    FOURTH(50000, "50,000", 4, false),
    FIFTH(5000, "5,000", 3, false),
    LOSING(0, "0", 0, false);

    private final int money;
    private final String formatedMoney;
    private final int count;
    private final boolean existBonusNumber;

    Ranking(int money, String formatedMoney, int count, boolean existBonusNumber) {
        this.money = money;
        this.formatedMoney = formatedMoney;
        this.count = count;
        this.existBonusNumber = existBonusNumber;
    }

    public int getMoney() {
        return money;
    }

    public String getFormatedMoney() {
        return formatedMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isExistBonusNumber() {
        return existBonusNumber;
    }
}