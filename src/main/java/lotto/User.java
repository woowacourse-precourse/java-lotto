package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;
    private double earning = 0;
    private List<Lotto> lottoBundle;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private Map<String,Integer> winningNumberCounting= Map.of(
            "first",0,
            "second",0,
            "third",0,
            "fourth",0,
            "fifth",0
    );

    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    public void setMoney() {
        int money;
        money = Integer.parseInt(Console.readLine());
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void makeLottoBundle(int howManyLotto) {
        for (int lottoBundleIndex=0; lottoBundleIndex<howManyLotto; lottoBundleIndex++) {
            lottoBundle.add(lotteryTicketingMachine.ticketLotto());
        }
    }

    public void inputWinningNumber() {
        int convertedWinningNumber;
        String inputtedWinningNumber;
        inputtedWinningNumber = Console.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        String[] unconvertedWinningNumber = inputtedWinningNumber.split(",");
        for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
            convertedWinningNumber = Integer.parseInt(unconvertedWinningNumberContent);
            winningNumber.add(convertedWinningNumber);
        }
        this.winningNumber = winningNumber;
    }

    public void inputBonusNumber() {
        String inputtedBonusNumber;
        inputtedBonusNumber = Console.readLine();
        this.bonusNumber = Integer.parseInt(inputtedBonusNumber);
    }

    public void countWinningNumber (int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber==6) {
            winningNumberCounting.put("first",winningNumberCounting.get("first")+1);
        } else if (howManyWinningNumber==5) {
            if (isBonusNumberCorrect) {
                winningNumberCounting.put("second",winningNumberCounting.get("second")+1);
                return;
            }
                winningNumberCounting.put("third",winningNumberCounting.get("third")+1);
        } else if (howManyWinningNumber==4) {
            winningNumberCounting.put("fourth",winningNumberCounting.get("fourth")+1);
        } else if (howManyWinningNumber==3) {
            winningNumberCounting.put("fifth",winningNumberCounting.get("fifth")+1);
        }
    }

    public void calculateEarning() {
        earning+=winningNumberCounting.get("first")*WinningNumberAndEarningPair.CORRECT_6.getEarning();
        earning+=winningNumberCounting.get("second")*WinningNumberAndEarningPair.CORRECT_5_BONUS.getEarning();
        earning+=winningNumberCounting.get("third")*WinningNumberAndEarningPair.CORRECT_5.getEarning();
        earning+=winningNumberCounting.get("fourth")*WinningNumberAndEarningPair.CORRECT_4.getEarning();
        earning+=winningNumberCounting.get("fifth")* WinningNumberAndEarningPair.CORRECT_3.getEarning();
    }

    public double calculateEarningRate() {
        double earningRate;
        earningRate = earning/money;
        return earningRate;
    }
}
