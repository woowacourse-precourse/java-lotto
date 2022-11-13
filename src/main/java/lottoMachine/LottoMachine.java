package lottoMachine;

import static lottoMachine.enums.Numbers.KINDS_OF_PRIZE;
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
        receiveMoney();
        createLottoTickets();
        setDevice();
        printPurchaseDetail();
        receiveWinningNumber();
        receiveBonusNumber();
        printWinningStatistics();
        printReturnOfRate();
        printReturnOfRate();
    }

    private void receiveMoney() {
        lottoMachineDevices.printReceivePriceMessage();
        banknoteSlot.receiveMoney();
    }

    private void createLottoTickets() {
        int numberOfLotto = getNumberOfLotto();
        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = new Lotto(NumberGenerator.createRandomNumber());
            lottoTickets.add(lotto);
        }
    }

    private void printPurchaseDetail() {
        lottoMachineDevices.printPurchaseAmount();
        lottoMachineDevices.printLottoTickets();
    }

    private void receiveWinningNumber() {
        lottoMachineDevices.printReceiveWinningNumberMessage();
        lottoMachineDevices.receiveWinningNumber();
    }

    private void receiveBonusNumber() {
        lottoMachineDevices.printReceiveBonusNumberMessage();
        lottoMachineDevices.receiveBonusNumber();
    }

    private void printWinningStatistics() {
        lottoMachineDevices.printWinningStatistics(getWinningHistory());
    }

    private void printReturnOfRate() {
        long totalWinningMoney = getTotalWinningMoney();
        int purchaseMoeny = banknoteSlot.getMoney();
        lottoMachineDevices.printReturnOfRate(totalWinningMoney, purchaseMoeny);
    }


    private int getNumberOfLotto() {
        int money = banknoteSlot.getMoney();
        return money / LOTTO_PRICE.getValue();
    }

    private void setDevice() {
        lottoMachineDevices.setLottoTickets(lottoTickets);
    }

    private List<Integer> getWinningHistory() {
        List<Integer> winningHistory = new ArrayList<>();
        for (int index = 0; index < KINDS_OF_PRIZE.getValue(); index++) {
            winningHistory.add(0);
        }
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> winningNumber = new ArrayList<>(lottoMachineDevices.getWinningNumbers());
            winningNumber.removeAll(lottoTicket.getNumbers());
            int size = winningNumber.size();
            int bonusNumber = lottoMachineDevices.getBonusNumber();
            makeWinningHistory(winningHistory, size, winningNumber.contains(bonusNumber));
        }
        return winningHistory;
    }

    private void makeWinningHistory(List<Integer> winningHistory, int size, boolean bonus) {
        if (size > 3) {
            return;
        }
        if (size >= 2 || (size == 1 && !bonus)) {
            Integer prev = winningHistory.get(size + 1);
            winningHistory.set(size + 1, prev + 1);
            return;
        }
        Integer prev = winningHistory.get(size);
        winningHistory.set(size, prev + 1);
    }

    private long getTotalWinningMoney() {
        List<Integer> winningHistory = getWinningHistory();
        int[] winningMoney = new int[]{2_000_000_000, 30_000_000, 1_500_000, 50_000, 5000};

        long totalWinningMoney = 0;
        for (int index = 0; index < winningHistory.size(); index++) {
            totalWinningMoney += winningHistory.get(index) * winningMoney[index];
        }
        return totalWinningMoney;
    }
}
