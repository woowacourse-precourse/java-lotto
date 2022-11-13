package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.LottoGenerator;
import lotto.validator.LottoPurchaseValidator;
import lotto.validator.UserInputValidator;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class LottoGame {

    public void start() {
        int inputMoney = receiveMoney();
        List<Lotto> purchasedLottos = purchaseLotto(inputMoney);
    }

    private int receiveMoney() {
        UserInputView.printInputPurchasePrice();
        String inputMoney = Console.readLine();
        UserInputValidator.validateStringIsNumeric(inputMoney);
        int inputMoneyParseInt = Integer.parseInt(inputMoney);
        LottoPurchaseValidator.validatePurchaseUnit(inputMoneyParseInt);
        return inputMoneyParseInt;
    }

    private List<Lotto> purchaseLotto(int inputMoney) {
        List<Lotto> purchasedLottos = LottoGenerator.generateByMoney(inputMoney);
        UserOutputView.printPurchaseQuantity(purchasedLottos.size());
        purchasedLottos.stream().forEach(lotto -> UserOutputView.printPurchasedLottoNumbers(lotto.getNumbers()));
        return purchasedLottos;
    }

}
