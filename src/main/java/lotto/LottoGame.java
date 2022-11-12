package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.Lotto;

public class LottoGame {
    private final Message message = new Message();
    private final ProcessInputAndVariable processInputAndVariable = new ProcessInputAndVariable();
    private final ManagementLotto managementLotto = new ManagementLotto();
    public void start() {
        try {
            Integer purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = purchaseLotto(purchasePrice);
        } catch (IllegalArgumentException exception) {
            message.printMsg(exception.getMessage());
        }
    }

    private Integer inputPurchasePrice() throws IllegalArgumentException {
        message.printPurchaseMsg();
        String price = Console.readLine();

        return processInputAndVariable.convertToInteger(price);
    }

    private List<Lotto> purchaseLotto(Integer price) {
        Integer lottoAmount = processInputAndVariable.calculateLottoAmount(price);
        List<Lotto> lottos = managementLotto.purchase(lottoAmount);

        return lottos;
    }
}
