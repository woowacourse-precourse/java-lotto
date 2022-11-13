package lottoMachine.device;

import static lottoMachine.enums.Messages.RECEIVE_PRICE_MESSAGE;
import static lottoMachine.enums.Messages.RESULT_OF_PURCHASE_MESSAGE;

import java.text.MessageFormat;
import java.util.List;
import lotto.Lotto;

public class LottoMachineDevices implements LottoMachineOutputDevice, LottoMachineInputDevice {

    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachineDevices() {
    }

    public void setLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public void printReceivePriceMessage() {
        System.out.println(RECEIVE_PRICE_MESSAGE);
    }

    @Override
    public void printPurchaseAmount() {
        String format = MessageFormat.format(RESULT_OF_PURCHASE_MESSAGE.toString(),
                lottoTickets.size());
        System.out.println(format);
    }

    @Override
    public void printLottoTickets() {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

}
