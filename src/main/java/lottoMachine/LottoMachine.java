package lottoMachine;

import static lottoMachine.enums.Numbers.KINDS_OF_PRIZE;
import static lottoMachine.enums.Numbers.LOTTO_PRICE;
import static lottoMachine.enums.Numbers.ZERO;
import static lottoMachine.enums.MatchNumber.THREE_NUMBERS_MATCH;
import static lottoMachine.enums.MatchNumber.FOUR_NUMBERS_MATCH;
import static lottoMachine.enums.MatchNumber.FIVE_NUMBERS_MATCH;
import static lottoMachine.enums.MatchNumber.SIX_NUMBERS_MATCH;
import static lottoMachine.enums.PrizeIndex.FIRST_PRIZE_INDEX;
import static lottoMachine.enums.PrizeIndex.SECOND_PRIZE_INDEX;
import static lottoMachine.enums.PrizeIndex.THIRD_PRIZE_INDEX;
import static lottoMachine.enums.PrizeIndex.FOURTH_PRIZE_INDEX;
import static lottoMachine.enums.PrizeIndex.FIFTH_PRIZE_INDEX;
import static lottoMachine.enums.Reward.FIRST_REWARD;
import static lottoMachine.enums.Reward.SECOND_REWARD;
import static lottoMachine.enums.Reward.THIRD_REWARD;
import static lottoMachine.enums.Reward.FOURTH_REWARD;
import static lottoMachine.enums.Reward.FIFTH_REWARD;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lottoMachine.device.LottoMachineDevices;
import lottoMachine.enums.Numbers;

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
        initWinningHistory(winningHistory);
        int bonusNumber = lottoMachineDevices.getBonusNumber();
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> unMatchedNumber = getUnMatchedNumber(lottoTicket);
            int wholeSize = Numbers.WINNING_NUMBER_SIZE.getValue();
            int unMatchedSize = unMatchedNumber.size();
            makeWinningHistory(winningHistory, wholeSize - unMatchedSize,
                    unMatchedNumber.contains(bonusNumber));
        }
        return winningHistory;
    }

    private List<Integer> getUnMatchedNumber(Lotto lottoTicket) {
        List<Integer> winningNumber = new ArrayList<>(lottoMachineDevices.getWinningNumbers());
        winningNumber.removeAll(lottoTicket.getNumbers());
        return winningNumber;
    }

    private void initWinningHistory(List<Integer> winningHistory) {
        for (int index = 0; index < KINDS_OF_PRIZE.getValue(); index++) {
            winningHistory.add(ZERO.getValue());
        }
    }


    private void makeWinningHistory(List<Integer> winningHistory, int numberOfMatched,
            boolean bonus) {
        if (numberOfMatched == THREE_NUMBERS_MATCH.getMatchNumber()) {
            setWinningHistory(winningHistory, FIFTH_PRIZE_INDEX.ordinal());
        }
        if (numberOfMatched == FOUR_NUMBERS_MATCH.getMatchNumber()) {
            setWinningHistory(winningHistory, FOURTH_PRIZE_INDEX.ordinal());
        }
        if (numberOfMatched == FIVE_NUMBERS_MATCH.getMatchNumber() && !bonus) {
            setWinningHistory(winningHistory, THIRD_PRIZE_INDEX.ordinal());
        }
        if (numberOfMatched == FIVE_NUMBERS_MATCH.getMatchNumber() && bonus) {
            setWinningHistory(winningHistory, SECOND_PRIZE_INDEX.ordinal());
        }
        if (numberOfMatched == SIX_NUMBERS_MATCH.getMatchNumber()) {
            setWinningHistory(winningHistory, FIRST_PRIZE_INDEX.ordinal());
        }
    }

    private void setWinningHistory(List<Integer> winningHistory, int index) {
        Integer prev = winningHistory.get(index);
        winningHistory.set(index, ++prev);
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
