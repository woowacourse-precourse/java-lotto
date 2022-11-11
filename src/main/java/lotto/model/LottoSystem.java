package lotto.model;

public class LottoSystem {

    public static final int PERCENTAGE_CONVERSION_NUMBER = 100;
    public static final String PROFIT_RATE_FORMAT = "%.1f%%";
    private final LottoNumbers lottoNumbers;
    private int usedMoney;

    public LottoSystem() {
        this.lottoNumbers = new LottoNumbers();
    }

    public void addRandomLotto(int n) {
        lottoNumbers.addRandomLotto(n);
    }

    public void setUsedMoney(int usedMoney) {
        this.usedMoney = usedMoney;
    }

    public String getProfitRage() {
        return String.format(PROFIT_RATE_FORMAT,
                ((float) lottoNumbers.getProfitSum() * PERCENTAGE_CONVERSION_NUMBER) / usedMoney);
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
