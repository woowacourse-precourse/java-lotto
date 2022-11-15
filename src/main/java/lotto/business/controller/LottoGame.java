package lotto.business.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.EnumMap;
import java.util.List;
import lotto.service.CalculateLotto;
import lotto.service.ManagementLotto;
import lotto.service.ProcessVariable;
import lotto.business.model.Lotto;
import lotto.business.model.LottoAnswer;
import lotto.business.model.ResultEnum;
import lotto.business.view.Message;

public class LottoGame {
    private final Message message = new Message();
    private final ProcessVariable processVariable = new ProcessVariable();
    private final ManagementLotto managementLotto = new ManagementLotto();
    private final CalculateLotto calculateLotto = new CalculateLotto();
    public void start() {
        try {
            Integer purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = purchaseLotto(purchasePrice);
            LottoAnswer lottoAnswer = makeWinNumber();
            EnumMap<ResultEnum, Integer> result = calculateLotto.calculateResult(lottos, lottoAnswer);
            Double roi = calculateLotto.calculateROI(purchasePrice, result);
            message.printResult(result, roi);
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

    private LottoAnswer makeWinNumber() throws IllegalArgumentException {
        message.printPlsInputWinNumber();
        String winNumber = Console.readLine();
        message.printPlsInputBonusNumber();
        String bonusNumber = Console.readLine();

        return new LottoAnswer(managementLotto.makeWinNumber(winNumber), managementLotto.makeBonusNumber(bonusNumber));
    }
}
