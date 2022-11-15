package lotto;

import static lotto.view.ConstantMents.*;

import lotto.controller.Casher;
import lotto.controller.TicketMachine;
import lotto.controller.WinResultManager;
import lotto.model.LottoStorage;
import lotto.view.BonusNumberReceiver;
import lotto.view.IssuedTicketsPrinter;
import lotto.view.MoneyReceiver;
import lotto.view.ResultPrinter;
import lotto.view.WinNumberReceiver;

public class Application {

    public static void main(String[] args) {
        System.out.println(INPUT_MONEY);
        try {
            LottoStorage.setInputMoney(MoneyReceiver.receiveMoney());
            LottoStorage.setNumberOfTickets(
                    Casher.getTicketNumber(LottoStorage.getInputMoney()));
            System.out.println("\n" + LottoStorage.getNumberOfTickets() + NUMBER_OF_TICKETS);
            LottoStorage.setLottoTickets(
                    TicketMachine.issueTickets(LottoStorage.getNumberOfTickets()));
            IssuedTicketsPrinter.printIssuedTickets();
            System.out.println("\n" + INPUT_WIN_NUMBER);
            LottoStorage.setWinNumbers(WinNumberReceiver.receiveWinNumber());
            System.out.println("\n" + INPUT_BONUS_NUMBER);
            LottoStorage.setBonusNumber(BonusNumberReceiver.receiveBonusNumber());
            System.out.println("\n" + WIN_STATS + "\n" + SPLIT_PARAGRAPH + "\n");
            LottoStorage.setResultCollection(
                    WinResultManager.getCorrectedNumbersWithWin(
                            LottoStorage.getLottoTickets(), LottoStorage.getWinNumbers(),
                            LottoStorage.getBonusNumber()));
            ResultPrinter.printResult(WinResultManager.correctCaseCollector(LottoStorage.getResultCollectionStorage()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
