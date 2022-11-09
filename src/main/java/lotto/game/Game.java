package lotto.game;

import static lotto.game.UI.*;

import java.util.List;
import lotto.Lotto;

public class Game {
    private final LottoService lottoService;

    private Game(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public static Game create(LottoService lottoService) {
        return new Game(lottoService);
    }

    public void start() {
        int money = lottoService.convertInputToMoney(receiveInput(MESSAGE_PURCHASE_MONEY));
        printPurchasedLottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        receiveInput(MESSAGE_WINNING_NUMBER);
        receiveInput(MESSAGE_BONUS_NUMBER);
        printTotalResult(12.345);
    }
}
