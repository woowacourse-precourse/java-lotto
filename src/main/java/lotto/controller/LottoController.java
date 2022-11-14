package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";
    private Player player;

    public LottoController() {
        getPlayerMoney();

        player.buyLotto();

        List<Lotto> playerLotteries = player.getLotteries();

        OutputView.printBuyingCount(playerLotteries);

    }

    private void getPlayerMoney() {
        String moneyInput = InputView.getMoney();

        validateMoney(moneyInput);

        int money = Integer.parseInt(moneyInput);

        player = new Player(money);
    }

    private void validateMoney(String moneyInput) {
        if (moneyInput.length() <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력의 길이가 잘못됐습니다.");
        }

        long money = 0;
        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해주세요.");
        }
    }
}
