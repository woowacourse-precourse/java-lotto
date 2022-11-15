package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.CalculateLotto;
import lotto.model.Lotto;
import lotto.ManagementLotto;
import lotto.Message;
import lotto.ProcessVariable;

public class LottoGame {

    private final Message message = new Message();
    private final ProcessVariable processVariable = new ProcessVariable();
    private final ManagementLotto managementLotto = new ManagementLotto();
    private final CalculateLotto calculateLotto = new CalculateLotto();

    public void start() {
        try {
            Integer purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = purchaseLotto(purchasePrice);
            LottoAnswer winNumber = inputWinNumber();
            //message.printResult(calculateLotto.calculateResult(lottos, winNumber));
            calculateLotto.calculateROI();
        } catch (IllegalArgumentException exception) {
            message.printMsg(exception.getMessage());
        }
    }

    private Integer inputPurchasePrice() throws IllegalArgumentException {
        message.printPurchaseMsg();
        String price = Console.readLine();

        return processVariable.convertToInteger(price);
    }

    private List<Lotto> purchaseLotto(Integer price) {
        Integer lottoAmount = processVariable.calculateLottoAmount(price);
        List<Lotto> lottos = managementLotto.purchase(lottoAmount);
        message.printPurchaseLotto(lottos);

        return lottos;
    }
    private LottoAnswer inputWinNumber() throws IllegalArgumentException {
        message.printPlsInputWinNumber();
        String winNumber = Console.readLine();
        message.printPlsInputBonusNumber();
        String bonusNumber = Console.readLine();

        return new LottoAnswer(managementLotto.makeWinNumber(winNumber), managementLotto.makeBonusNumber(bonusNumber));
    }
}
