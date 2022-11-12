package lotto.entity;

public class User {
    private int purchaseAmount;
    private int userNumber;
    private int lottoAmount;
    public User(){}

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public void setLottoAmount(int lottoAmount) {
        this.lottoAmount = lottoAmount;
    }
}
