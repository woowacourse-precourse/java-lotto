package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE=1000;
    private int money;
    private int lottoCount;

    public Money(int money){
        this.money=money;
        this.lottoCount=money/LOTTO_PRICE;
    }
    public int getMoney(){ return money;}
    public int getLottoCount(){ return lottoCount; }
}
