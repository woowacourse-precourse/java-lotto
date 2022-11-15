package lotto.Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.Exception;
import lotto.Util.Util;

public class User {
    private int money;
    private int bonusNumber;
    private double earning = 0;
    private List<Lotto> lottoBundle = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private List<Integer> winningNumberCounting= new ArrayList<>(8);
    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();
    Exception exception = new Exception();

    Util util = new Util();

    public User() {
        for (int i=0; i<8; i++) {
            winningNumberCounting.add(0);
        }
    }

    public void setMoney() {
        int money;

        try {
            money = Integer.parseInt(Console.readLine());
            this.money=money;
        } catch (NumberFormatException e) {
            exception.throwInvalidInputException();
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

    public double getEarning() {
        return earning;
    }

    public void makeLottoBundle(int howManyLotto) {
        for (int lottoBundleIndex=0; lottoBundleIndex<howManyLotto; lottoBundleIndex++) {
            lottoBundle.add(lotteryTicketingMachine.ticketLotto());
        }
    }

    public void inputWinningNumber() throws IllegalArgumentException  {
        List<Integer> winningNumber = new ArrayList<>();

        try {
            winningNumber = util.splitStringToIntegerArray(Console.readLine());
            util.checkWinningNumberValidation(winningNumber);
        } catch(NumberFormatException e) {
            exception.throwInvalidInputException();
        }
        this.winningNumber=winningNumber;
    }
    
    public void inputBonusNumber() throws IllegalArgumentException {
        try{
            int inputtedBonusNumber = Integer.parseInt(Console.readLine());
            bonusNumber = inputtedBonusNumber;
            util.checkNumberRange(inputtedBonusNumber);
        } catch (NumberFormatException e) {
            exception.throwInvalidInputException();
        }
    }

    public void countWinningNumber (int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber>=5) {
            howManyWinningNumber++;
            if (howManyWinningNumber==6&&(!isBonusNumberCorrect)) {
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
