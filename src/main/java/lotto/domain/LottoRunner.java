package lotto.domain;

import java.util.List;
import lotto.ui.LottoInStream;
import lotto.ui.LottoOutStream;

public class LottoRunner {
    public static void run() {
        try {
            LottoGame game = new LottoGame(LottoInStream.readAmount());
            game.buy();

            LottoOutStream.showLottoList(game);

            game.setWinningLotto(new Lotto(LottoInStream.readLottoNumbers()));
            game.setBonusNumber(LottoInStream.readBonusNumber(game.getWinningLotto()));
            game.getResult();

            LottoOutStream.showResult(game);
            LottoOutStream.showROR(game);
        } catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
