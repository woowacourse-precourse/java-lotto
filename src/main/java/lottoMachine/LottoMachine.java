package lottoMachine;

import static lottoMachine.enums.Numbers.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoMachine {

    private final BanknoteSlot banknoteSlot;
    private final List<Lotto> lottoTickets;

    public LottoMachine() {
        banknoteSlot = new BanknoteSlot();
        lottoTickets = new ArrayList<>();
    }

    public void startLottoGame() {
        receiveMoney();
        createLottoTickets();
    }

    public void receiveMoney() {
        LottoMachinePrinter.printReceivePriceMessage();
        banknoteSlot.receiveMoney();
    }

    public void createLottoTickets() {
        int numberOfLotto = getNumberOfLotto();
        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = new Lotto(NumberGenerator.createRandomNumber());
            lottoTickets.add(lotto);
        }
        LottoMachinePrinter.printPurchaseAmount(numberOfLotto);
        LottoMachinePrinter.printLottoTickets(lottoTickets);
    }

    private int getNumberOfLotto() {
        int money = banknoteSlot.getMoney();
        return money / LOTTO_PRICE.getValue();
    }
}
