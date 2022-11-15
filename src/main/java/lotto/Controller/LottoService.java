package lotto.Controller;

import Utils.InputUtils;
import lotto.Domain.Player;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoService {
    private Player player;

    public LottoService(Player player) {
        this.player = player;
    }

    public void purchaseLottoService() throws IllegalArgumentException {
        recievePlayerMoney();
        purchaseLotto();
    }

    public void recievePlayerMoney() throws IllegalArgumentException {
        String lottoMoney = InputView.requestLottoMoney();
        isValidateLottoMoney(lottoMoney);
        player.setMoney(Integer.parseInt(lottoMoney));
    }

    public void purchaseLotto() throws IllegalArgumentException  {
        int lottoMoney = player.getMoney();
        int lottoCount = player.getLottoCount(lottoMoney);
        player.setLottos(lottoCount);
        OutputView.printPurchaseLotto(lottoCount, player.getLottosToOutput());
    }

    public void isValidateLottoMoney(String money) {
        final String ERROR_MESSAGE = "[ERROR] 1000원의 배수인 금액을 입력하여야 합니다.";
        if(!InputUtils.isDigit(money) || !InputUtils.isMultipleOfOneThousand(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}