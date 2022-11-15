package lotto;

import java.util.List;

public class Calculation {
    public static Integer calculateNumberOfLottoes(Integer enteredMoney) {
        int numberOfLottoes = enteredMoney / 1000;
        return numberOfLottoes;
    }

    public static int calculateMatchNumber(List<Integer> oneLotto, List<Integer> prizeNumber){
        int matchNumber = 0;
        for (int index = 0; index < prizeNumber.size(); index++){
            if(prizeNumber.contains(oneLotto.get(index))){
                matchNumber += 1;
            }
        }
        return matchNumber;
    }

    public static boolean calculateMatchNumber(List<Integer> oneLotto, int bonusNumber) {
        return (oneLotto.contains(bonusNumber));
    }

}
