package lotto.Domain;

public class Player {
    private int money;
    private int lottoCount;
    private int Lottos;

    public void setLottoCount(int money){
        final int THOUSAND_WON = 1000;
        this.lottoCount = money / THOUSAND_WON;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
