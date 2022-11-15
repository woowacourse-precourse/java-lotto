package lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryHostAgency {

    private List<Integer> winningNumbers;
    private int bonusNumber = 1;

    protected void setWinningNumbers(List<Integer> numbers) {
        Lotto.isValidList(numbers);
        this.winningNumbers = new ArrayList<>((numbers));
    }

    protected void isValidNumber(int number) {
        if (!((0 < number) && (number < 46)))
            throw new IllegalArgumentException("[ERROR] Number must between 1 and 45");
        if (this.winningNumbers.contains(number))
            throw new IllegalArgumentException("[ERROR] Bonus number must not be in the Winning numbers");

    }

    protected void setBonusNumber(int number) {
        isValidNumber(number);
        this.bonusNumber = number;
    }


    public void setDrawalNumbers(List<Integer> winningNumbers, int bonusNumber) {
        setWinningNumbers(winningNumbers);
        setBonusNumber(bonusNumber);
    }

    public WinningCriteria getResult(Lotto challenge) {
        List<Integer> challengeNumbers = challenge.getNumbers();
        int matchCount = (int) winningNumbers.parallelStream().filter(challengeNumbers::contains).count();
        if (matchCount == 6) return WinningCriteria.FIRST;
        if (matchCount == 5 && challengeNumbers.contains(bonusNumber)) return WinningCriteria.SECOND;
        if (matchCount == 5) return WinningCriteria.THIRD;
        if (matchCount == 4) return WinningCriteria.FORTH;
        if (matchCount == 3) return WinningCriteria.FIFTH;
        return WinningCriteria.NOTHING;
    }


    public enum WinningCriteria {
        FIRST(2000000000,6), SECOND(30000000,5), THIRD(1500000,5 ), FORTH(50000,4), FIFTH(5000,3 ), NOTHING(0,0);
        int amount;
        int matches;

        WinningCriteria(int amount, int matches) {
            this.amount = amount;
            this.matches = matches;
        }
    }


}
