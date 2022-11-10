package lotto.model;

class LottoSystem {

    private final LottoNumbers lottoNumbers;
    private int usedMoney;
    LottoSystem() {
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

    public String getProfitRage(int profit) {
        return String.format("%.1f%%", ((float) profit * 100) / usedMoney);
    }
}
