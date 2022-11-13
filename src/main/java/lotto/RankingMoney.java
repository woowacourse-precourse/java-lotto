package lotto;
/*
설명 -  등수별 돈 정수형 상수 선언
FIRST - 1등
SECOND - 2등
THIRD -  3등
FOURTH - 4등
FIFTH - 5등
 */
public enum RankingMoney {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);
    private int money;
    RankingMoney(int i) {
        this.money=i;
    }
    public int getMoney(){
        return money;
    }
}
