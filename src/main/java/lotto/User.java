package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;
    private double earning = 0;
    private List<Lotto> lottoBundle;

    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    public void setMoney() {
        int money;
        money = Integer.parseInt(Console.readLine());
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void makeLottoBundle(int howManyLotto) {
        for (int lottoBundleIndex=0; lottoBundleIndex<howManyLotto; lottoBundleIndex++) {
            lottoBundle.add(lotteryTicketingMachine.ticketLotto());
        }
    }

    public List<Integer> inputWinningNumber() {
        int convertedWinningNumber;
        String inputtedWinningNumber;
        inputtedWinningNumber = Console.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        String[] unconvertedWinningNumber = inputtedWinningNumber.split(",");
        for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
            convertedWinningNumber = Integer.parseInt(unconvertedWinningNumberContent);
            winningNumber.add(convertedWinningNumber);
        }
        return winningNumber;
    }

    public int inputBonusNumber() {
        String inputtedBonusNumber;
        inputtedBonusNumber = Console.readLine();
        return Integer.parseInt(inputtedBonusNumber);
    }

    public void calculateEarning(int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber==6) {
            earning+=WinningNumberAndEarningPair.CORRECT_6.getEarning();
        } else if (howManyWinningNumber==5) {
            if (isBonusNumberCorrect) {
                earning+=WinningNumberAndEarningPair.CORRECT_5_BONUS.getEarning();
            }
            earning+=WinningNumberAndEarningPair.CORRECT_5.getEarning();
        } else if (howManyWinningNumber==4) {
            earning+=WinningNumberAndEarningPair.CORRECT_4.getEarning();
        } else if (howManyWinningNumber==3) {
            earning += WinningNumberAndEarningPair.CORRECT_3.getEarning();
        }
    }

    public double calculateEarningRate() {
        double earningRate;
        earningRate = earning/money;
        return earningRate;
    }
}
