package lotto;

public class Game {
    private final LottoStore lottoStore = new LottoStore();

    public void play() {
        lottoStore.payLotto();
        lottoStore.buyLotto();
    }
}
