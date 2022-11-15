package lotto;

import lotto.Account.Account;
import lotto.Calculator.EarningRateCalculator;
import lotto.Generator.LottoNumberGenerator;
import lotto.Lotto.BonusNumber;
import lotto.Lotto.Lotto;
import lotto.Printer.Printer;
import lotto.Receiver.Receiver;

import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    private static final Integer STANDARD_AMOUNT = 1000;

    private final Printer printer;
    private final Receiver receiver;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final EarningRateCalculator earningRateCalculator;

    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoPlayer() {
        printer = new Printer();
        receiver = new Receiver();
        lottoNumberGenerator = new LottoNumberGenerator();
        earningRateCalculator = new EarningRateCalculator();
    }

    public void playLotto() {
        printer.requestPurchaseAmount();
        Account userAccount = new Account(receiver.receiveLine());
        Integer numberOfTickets = userAccount.getPurchaseAmount() / STANDARD_AMOUNT;

        printer.printPurchaseMessage(numberOfTickets);
        issueLotto(numberOfTickets);
        printer.requestLottoNumber();
        Lotto lotto = new Lotto(receiver.receiveLine());
        printer.requestBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(receiver.receiveLine());

        earningRateCalculator.checkMatching(lotto.getNumbers(), lottos, bonusNumber.getBonusNumber(), printer);
    }

    private void issueLotto( Integer numberOfTickets) {
        for (int repeat = 0; repeat < numberOfTickets; repeat++) {
            List<Integer> newLottoNumber = lottoNumberGenerator.generateLottoNumber();
            this.lottos.add(newLottoNumber);
            printer.printIssuedLottoNumber(newLottoNumber);
        }
    }

}
