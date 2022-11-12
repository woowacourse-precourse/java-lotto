package lotto.domain;

public class LottoStore {

    private final Player player;
    private Lotto winningLotto;

    public LottoStore(LottoPurchaseAmount lottoPurchaseAmount) {
        this.player = new Player(lottoPurchaseAmount);
    }

    public void createWinningLotto(String winningNumbers) {
        winningLotto = new Lotto(winningNumbers);
    }

    public LottoResult calculateLottoResult(LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        player.calculateLottoRanking(lottoResult, winningLotto, bonusNumber);
        return lottoResult;
    }
}
