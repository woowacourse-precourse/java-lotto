package lotto;

public enum RankOfLotto {
    NOTHING(0),
    FIRSTPRIZE(2000000000),
    SECONDPRIZE(30000000),
    THIRDPRIZE(1500000),
    FOURTHPRIZE(50000),
    FIFTHPRIZE(5000);

    private final int money;
    RankOfLotto(int money) {this.money = money;}

    public int getMoney() {return money;}
}
