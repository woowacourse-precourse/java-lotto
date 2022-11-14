package lotto;

public enum PrizeInfo {
    Fifth("3개 일치","(5,000원)",5000),
    Fourth("4개 일치","(50,000원)",50000),
    Third("5개 일치","(1,500,000원)",1500000),
    Second("5개 일치, 보너스 볼 일치","(30,000,000원)",30000000),
    One("6개 일치", "(2,000,000,000원)", 2000000000);

    private final String count, money;
    private final int realmoney;

    private PrizeInfo(String count, String money, int realmoney){
        this.count = count;
        this.money = money;
        this.realmoney = realmoney;
    }
}
