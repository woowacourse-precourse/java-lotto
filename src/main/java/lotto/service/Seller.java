package lotto.service;

import lotto.domain.Money;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.correctLotto.CorrectLottoNumbers;
import lotto.service.input.InputConsole;
import lotto.service.view.ViewConsole;

public class Seller {
    private Money money;
    private Lottos lottos;
    private LottoNumbers correctNumbers;
    private LottoNumber bonusNumber;


    public void acceptMoney() {
        ViewConsole.printInputMoney();
        money = InputConsole.readMoney();
        System.out.println();
    }

    public void makeLottos() {
        lottos = LottoMachine.makeLottos(money);
        ViewConsole.printLottoLineCount(lottos.getSizeOfLottoLines());
        ViewConsole.printLottoLineDetails(lottos);
        System.out.println();
    }

    public void makeCorrectNumber() {
        ViewConsole.printInputCorrectNumber();
        correctNumbers = InputConsole.readCorrectNumbers();
        System.out.println();

        ViewConsole.printInputBonusNumber();
        bonusNumber = InputConsole.readBonusNumber();
        System.out.println();
    }

}