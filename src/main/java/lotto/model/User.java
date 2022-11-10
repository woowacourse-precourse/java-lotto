package lotto.model;

public class User {
    private int userPrice;
    private int userGameCnt;
    public User() {
        userPrice=0;
    }

    public void setUserPrice(int userPrice) {
        this.userGameCnt=userPrice/1000;
        this.userPrice = userPrice;
    }

    public int getUserGameCnt() {
        return userGameCnt;
    }
}
