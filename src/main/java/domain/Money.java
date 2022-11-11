package domain;

import vo.LottoInfo;

public class Money {

    private final String userMoney;


    public Money(String userMoney) {
        this.userMoney = userMoney;
    }

    public int getLottoCount() {
        int totalMoney = Integer.parseInt(userMoney);
        return totalMoney/LottoInfo.PRICE;
    }
}
