package lotto.model;

class LottoSystem {


    private final LottoNumbers lottoNumbers;

    LottoSystem() {
        this.lottoNumbers = new LottoNumbers();
    }

    public void addRandomLotto(int n) {
        lottoNumbers.addRandomLotto(n);
    }

    public int getLottoQuantity() {
        return lottoNumbers.getLottoQuantity();
    }

}
