package lotto.model;

import lotto.Utils.InputValid;

import java.util.List;

public class User {
    private static final int USER_PRICE_UNIT=1000;

    private int userPrice;
    private int userGameCnt;

    public User() {
        userPrice=0;
        userGameCnt=0;
    }

    public void setUserPrice(int userPrice) {
        this.userGameCnt=userPrice/ USER_PRICE_UNIT;
        this.userPrice = userPrice;
    }

    public int getUserGameCnt() {
        return userGameCnt;
    }

    public int getUserPrice() {
        return userPrice;
    }
}
