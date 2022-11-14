package lotto.model;

public class User {

    public static final float PERCENTAGE_CONVERSION_NUMBER = 100f;

    private final LottoNumbers lottoNumbers;
    private int usedMoney;

    public User() {
        this.lottoNumbers = new LottoNumbers();
    }

    public void addRandomLotto(int n) {
        lottoNumbers.addRandomLotto(n);
    }

    public void addMoney(int usedMoney) {
        this.usedMoney += usedMoney;
    }

    public float getProfitRage(Lotto targetLotto, int bonusNumber) {
        return lottoNumbers.getProfitSum(targetLotto, bonusNumber) * PERCENTAGE_CONVERSION_NUMBER / usedMoney;
    }

    public String getPurchaseDetails() {
        return lottoNumbers.getPurchaseDetails();
    }

    public String getResult(Lotto targetLotto, int bonusNumber) {
        return lottoNumbers.getResult(targetLotto, bonusNumber);
    }

    int getLottoQuantity() {
        return lottoNumbers.getLottoQuantity();
    }
}
