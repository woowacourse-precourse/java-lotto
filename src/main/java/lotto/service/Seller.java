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

    public void acceptMoney() {
        ViewConsole.printInputMoney();
        money = InputConsole.readMoney();
        System.out.println();
    }

}
