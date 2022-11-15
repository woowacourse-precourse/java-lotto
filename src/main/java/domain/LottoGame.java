package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputBonusNumber;
import view.InputUserMoney;
import view.InputWinningLottoNumber;
import view.OutputView;

public class LottoGame {


    static final Integer BONUS = 7;
    static final int MINIMUM_WINNING = 3;
    static final int THIRD_RANK = 5;
    static final int ONE_HUNDRED = 100;

    static final List<Integer> moneyRanks = Arrays.asList(5000, 50000, 1500000, 2000000000,
        30000000);

    static List<Integer> rankedBox = new ArrayList<>();
    List<List<Integer>> buyLottoTickets = new ArrayList<>();
    List<Integer> winningLottoTicket = new ArrayList<>();
    List<Integer> matchCountBox = new ArrayList<>();
    int bonusNumber;
    static long sumMoney;
    static float yield;

    public static List<Integer> getRankedBox() {
        return rankedBox;
    }

    public void Game() {

        setGame();
        bonusNumber = InputBonusNumber.getBonusNumber();
        for (int index = 0; index < buyLottoTickets.size(); index++) {
            List<Integer> nowLottoTicket = buyLottoTickets.get(index);
            matchCountBox.add(matchCount(winningLottoTicket, nowLottoTicket, bonusNumber));
        }

        calculateResultProcess(matchCountBox);
        OutputView.printStatistics();

    }


    public static float getYield() {
        return yield;
    }

    private void calculateResultProcess(List<Integer> matchCountBox) {
        countingRank(matchCountBox);
        sumMoney = calculateSumMoney(rankedBox);
        yield = setYield((float) sumMoney);

    }

    private float setYield(float sumMoney) {
        float yield = sumMoney / (float) InputUserMoney.getUserMoney() * ONE_HUNDRED;
        return yield;
    }

    private long calculateSumMoney(List<Integer> rankedBox) {
        long sumGetMoney = 0;
        for (int index = 0; index < rankedBox.size(); index++) {
            Integer nowRankMoney = moneyRanks.get(index);
            Integer howManyRanked = rankedBox.get(index);
            sumGetMoney += nowRankMoney * howManyRanked;
        }

        return sumGetMoney;
    }

    private void countingRank(List<Integer> matchCountBox) {
        for (int index = MINIMUM_WINNING; index <= BONUS; index++) {
            int finalJ = index;
            rankedBox.add((int) matchCountBox.stream().filter(n -> n == finalJ).count());
        }
    }

    public void setGame() {
        this.buyLottoTickets = BuyLottoTickets.getBuyLottoTickets();
        this.winningLottoTicket = InputWinningLottoNumber.getWinningLottoTicket();
        this.bonusNumber = InputBonusNumber.getBonusNumber();
    }

    public static Integer matchCount(List<Integer> winningLottoTicket,
        List<Integer> nowBuyLottoTicket, int bonusNumber) {
        long count = winningLottoTicket.stream().filter(n -> nowBuyLottoTicket.contains(n)).count();
        if (count == THIRD_RANK) {
            if (isInBonusNumber(nowBuyLottoTicket, bonusNumber)) {
                return BONUS;
            }
        }
        return Math.toIntExact(count);
    }

    public static boolean isInBonusNumber(List<Integer> nowBuyLottoTicket, int bonusNumber) {
        return nowBuyLottoTicket.contains(bonusNumber);
    }


}
