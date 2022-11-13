package lottoMachine;

import static lottoMachine.enums.Numbers.KINDS_OF_PRIZE;
import static lottoMachine.enums.Numbers.LOTTO_PRICE;
import static lottoMachine.enums.Reward.FIFTH_REWARD;
import static lottoMachine.enums.Reward.FIRST_REWARD;
import static lottoMachine.enums.Reward.FOURTH_REWARD;
import static lottoMachine.enums.Reward.SECOND_REWARD;
import static lottoMachine.enums.Reward.THIRD_REWARD;

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
        int[] winningMoney = new int[]{FIRST_REWARD.getReward(), SECOND_REWARD.getReward(),
                THIRD_REWARD.getReward(), FOURTH_REWARD.getReward(), FIFTH_REWARD.getReward()};

        long totalWinningMoney = 0;
        for (int index = 0; index < winningHistory.size(); index++) {
            totalWinningMoney += (long) winningHistory.get(index) * winningMoney[index];
        }
        return totalWinningMoney;
    }
}
