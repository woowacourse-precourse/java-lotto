package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;
    private double earning = 0;
    private List<Lotto> lottoBundle = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;
    private List<Integer> winningNumberCounting= new ArrayList<>(8);

    public User() {
        for (int i=0; i<8; i++) {
            winningNumberCounting.add(0);
        }
    }

    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    public void setMoney() throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
            this.money=money;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
        }
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

    public List<Integer> getWinningNumberCounting() {
        return winningNumberCounting;
    }

    public void makeLottoBundle(int howManyLotto) {
        for (int lottoBundleIndex=0; lottoBundleIndex<howManyLotto; lottoBundleIndex++) {
            lottoBundle.add(lotteryTicketingMachine.ticketLotto());
        }
    }

    public void inputWinningNumber() throws IllegalArgumentException  {
        int convertedWinningNumber;
        String inputtedWinningNumber;
        try {
            inputtedWinningNumber = Console.readLine();
            List<Integer> winningNumber = new ArrayList<>();
            String[] unconvertedWinningNumber = inputtedWinningNumber.split(",");
            for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
                convertedWinningNumber = Integer.parseInt(unconvertedWinningNumberContent);
                winningNumber.add(convertedWinningNumber);
            }
            this.winningNumber = winningNumber;
        } catch(NumberFormatException e) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
    }
    
    public void inputBonusNumber() {
        String inputtedBonusNumber;
        inputtedBonusNumber = Console.readLine();
        this.bonusNumber = Integer.parseInt(inputtedBonusNumber);
    }

    public void countWinningNumber (int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber>=5) {
            howManyWinningNumber++;
            if (!isBonusNumberCorrect) {
                howManyWinningNumber--;
            }
        } else if (howManyWinningNumber<3) {
            howManyWinningNumber=2;
        }
        winningNumberCounting.set(howManyWinningNumber,winningNumberCounting.get(howManyWinningNumber)+1);
    }

    public void calculateEarning() {
        Arrays.stream(WinningNumberAndEarningPair.values())
            .forEach(tmp -> earning=earning+tmp.getEarning()*winningNumberCounting.get(tmp.ordinal()+2));
    }

    public double calculateEarningRate() {
        double earningRate;
        earningRate = earning/money;
        return earningRate;
    }
}
