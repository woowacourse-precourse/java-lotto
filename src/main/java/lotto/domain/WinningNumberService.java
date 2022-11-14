package lotto.domain;

import java.util.List;
import lotto.model.Lotto;
import lotto.utils.StringParser;

public class WinningNumberService {
    private Lotto lotteryWinningNumbers;
    private int bonus;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public void parseWinningNumber(String input){
        try{
            lotteryWinningNumbers = new Lotto(StringParser.stringToIntegerList(input));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void parseBonusNumber(String input){
        try{
            int bonus = Integer.parseInt(input);
            checkRange(bonus);
            checkDuplication(bonus);
            this.bonus = bonus;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto getLotteryWinningNumbers() {
        return lotteryWinningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    private void checkRange(int number){
        if(number > MAX || number < MIN){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplication(int number){
        if(lotteryWinningNumbers.getNumbers().contains(number)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
