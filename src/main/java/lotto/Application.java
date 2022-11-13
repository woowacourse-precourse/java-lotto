package lotto;

import java.util.List;

public class Application {
    public static final String _error = "[ERROR]";

    public static void main(String[] args) {
        int money = LottoInStream.readAmount();
        List<Lotto> lottoes = LottoGame.buyLotto(money);
        LottoOutStream.showLottoList(lottoes);

        Lotto winningLotto = new Lotto(LottoInStream.readLottoNumbers());
        int bonusNumber = LottoInStream.readBonusNumber(winningLotto);

        int[] matches = LottoGame.getResultLotto(lottoes, winningLotto, bonusNumber);

        LottoOutStream.showLottoResult(matches);
        LottoOutStream.showRateOfReturn(LottoGame.calcRateOfReturn(matches, money));
    }

    public static void lottoError(String error_msg) {
        System.out.print(_error + " " + error_msg);
        throw new IllegalArgumentException();
    }
}
