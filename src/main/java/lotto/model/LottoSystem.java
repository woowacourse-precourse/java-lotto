package lotto.model;

public class LottoSystem {

    private final LottoNumbers lottoNumbers;
    private int usedMoney;
    public LottoSystem() {
        this.lottoNumbers = new LottoNumbers();
    }

    public void addRandomLotto(int n) {
        lottoNumbers.addRandomLotto(n);
    }

    public int getLottoQuantity() {
        return lottoNumbers.getLottoQuantity();
    }

    public void setUsedMoney(int usedMoney) {
        this.usedMoney = usedMoney;
    }

    public String getProfitRage() {
        return String.format("%.1f%%", ((float) lottoNumbers.getProfitSum() * 100) / usedMoney);
    }

    public String getPurchaseDetails() {
        return lottoNumbers.getPurchaseDetails();
    }

    public String getResult(Lotto targetLotto,int bonusNumber) {
        return lottoNumbers.getResult(targetLotto,bonusNumber);
    }
}
