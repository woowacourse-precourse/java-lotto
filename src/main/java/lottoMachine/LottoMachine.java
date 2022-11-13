package lottoMachine;

import static lottoMachine.enums.Numbers.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lottoMachine.device.LottoMachineDevices;

public class LottoMachine {

    private final BanknoteSlot banknoteSlot;
    private final LottoMachineDevices lottoMachineDevices;
    private final List<Lotto> lottoTickets;

    public LottoMachine() {
        banknoteSlot = new BanknoteSlot();
        lottoMachineDevices = new LottoMachineDevices();
        lottoTickets = new ArrayList<>();
    }

    public void startLottoGame() {
        lottoMachineDevices.printReceivePriceMessage();
        banknoteSlot.receiveMoney();
        createLottoTickets();
        setDevice();
        lottoMachineDevices.printPurchaseAmount();
        lottoMachineDevices.printLottoTickets();
        lottoMachineDevices.printReceiveWinningNumberMessage();
        lottoMachineDevices.receiveWinningNumber();
        lottoMachineDevices.printReceiveBonusNumberMessage();
        lottoMachineDevices.receiveBonusNumber();
    }

    public void createLottoTickets() {
        int numberOfLotto = getNumberOfLotto();
        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = new Lotto(NumberGenerator.createRandomNumber());
            lottoTickets.add(lotto);
        }
    }

    private int getNumberOfLotto() {
        int money = banknoteSlot.getMoney();
        return money / LOTTO_PRICE.getValue();
    }

    private void setDevice() {
        lottoMachineDevices.setLottoTickets(lottoTickets);
    }
}
