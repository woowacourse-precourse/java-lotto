package lotto.domain.game;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.Player;
import lotto.utils.number.LottoNumbersGenerator;

public class LottoGame {

    private final Player player;
    private Lotto winningLotto;

    public LottoGame(BigDecimal amountInput, LottoNumbersGenerator generator) {
        this.player = new Player(amountInput, generator);
    }

    public void createWinningLotto(String winningNumbers) {
        winningLotto = new Lotto(winningNumbers);
    }

    public LottoResult calculateLottoResult(LottoNumber bonusNumber) {
        return new LottoResult(player, winningLotto, bonusNumber);
    }

    public List<String> getPlayerPurchaseLottos() {
        return player.getPurchaseLottos();
    }
}
