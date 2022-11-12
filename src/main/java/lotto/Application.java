package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = LottoInStream.readAmount();
        List<Lotto> lottoes = LottoGame.buyLotto(money);
        LottoOutStream.outStreamLottoesNumber(lottoes);

        Lotto winningLotto = new Lotto(LottoInStream.readLottoNumbers());
        int bonusNumber = LottoInStream.readBonusNumber(winningLotto);

        int[] matches = LottoGame.getResultLotto(lottoes, winningLotto, bonusNumber);

        LottoOutStream.outStreamLottoResult(matches);
        LottoOutStream.outStreamRateOfReturn(LottoGame.calcRateOfReturn(matches, money));
    }
}
