package Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;
    private int bonusNumber;
    private double earning = 0;
    private List<Lotto> lottoBundle = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private List<Integer> winningNumberCounting= new ArrayList<>(8);
    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

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
            System.out.println("[ERROR] 잘못된 입력 형식입니다.");
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
        List<Integer> winningNumber;
        try {
            winningNumber = splitStringToIntegerArray(Console.readLine());
        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            throw new IllegalArgumentException();
        }
        this.winningNumber=winningNumber;
    }

    public List<Integer> splitStringToIntegerArray(String inputtedWinningNumber) {
        List<Integer> listedWinningNumber = new ArrayList<>();
        String[] unconvertedWinningNumber = inputtedWinningNumber.split(",");
        for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
            listedWinningNumber.add(Integer.parseInt(unconvertedWinningNumberContent));
        }
        return listedWinningNumber;
    }
    
    public void inputBonusNumber() throws IllegalArgumentException {
        try{
            int inputtedBonusNumber = Integer.parseInt(Console.readLine());
            bonusNumber = inputtedBonusNumber;
            checkBonusNumberRange(inputtedBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber<1||bonusNumber>45) {
            System.out.println("[ERROR] 숫자의 범위는 1 이상 45 이하여야 합니다.");
            throw new IllegalArgumentException();
        }
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
