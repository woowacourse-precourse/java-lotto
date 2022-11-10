package lotto.model;

class LottoSystem {


    private final LottoNumbers lottoNumbers;

    LottoSystem() {
        this.lottoNumbers = new LottoNumbers();
    }

    public void addLotto(int n) {
        lottoNumbers.addLotto(n);
    }

    public int getLottoQuantity() {
        return lottoNumbers.getLottoQuantity();
    }

}
