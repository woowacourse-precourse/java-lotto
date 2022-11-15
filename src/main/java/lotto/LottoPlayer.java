package lotto;

import lotto.Account.Account;
import lotto.Generator.LottoNumberGenerator;
import lotto.Lotto.BonusNumber;
import lotto.Lotto.Lotto;
import lotto.Printer.Printer;
import lotto.Receiver.Receiver;

import java.util.List;

public class LottoPlayer {
    private static final Integer STANDARD_AMOUNT = 1000;

    private final Printer printer;
    private final Receiver receiver;
    private final LottoNumberGenerator lottoNumberGenerator;

    private List<List<Integer>> lottos;

    public LottoPlayer() {
        printer = new Printer();
        receiver = new Receiver();
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void playLotto() {
        printer.requestPurchaseAmount();
        Account userAccount = new Account(receiver.receiveLine());
        Integer numberOfTickets = userAccount.getPurchaseAmount() / STANDARD_AMOUNT;

        printer.printPurchaseMessage(numberOfTickets);
        issueLotto(lottoNumberGenerator, numberOfTickets);
        printer.requestLottoNumber();
        Lotto lotto = new Lotto(receiver.receiveLine());
        printer.requestBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(receiver.receiveLine());


    }

    private void issueLotto(LottoNumberGenerator lottoNumberGenerator, Integer numberOfTickets) {
        for (int repeat = 0; repeat < numberOfTickets; repeat++) {
            List<Integer> newLottoNumber = lottoNumberGenerator.generateLottoNumber();
            lottos.add(newLottoNumber);
            printer.printIssuedLottoNumber(newLottoNumber);
        }
    }

}
