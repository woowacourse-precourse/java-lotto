package lotto;

import lotto.model.LottoGenerator;
import lotto.model.Player;
import lotto.model.Service;

public class Controller {

    Player player = new Player();
    Service service = new Service();

    private void buyLotto() {
        String purchaseAmount = player.getInput();
        int lottoAmount = service.getLottoAmount(purchaseAmount);

        for (int i = 0; i < lottoAmount; i++) {
            LottoGenerator.getWinningNumbers();
        }
    }
    
}
