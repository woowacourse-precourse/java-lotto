package lotto.domain;


public class Money {
    private final Integer myMoney;
    private final Integer lottoCount;

    public Money(Integer money) {
        validate(money);
        this.myMoney = money;
        this.lottoCount = money / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    private void validate(Integer money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}
