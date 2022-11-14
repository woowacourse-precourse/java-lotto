package lotto.view;

import lotto.model.Result;

import java.util.List;

import static lotto.view.ViewEnum.*;

public class OutputView {
    public static void printGameCount(int userGameCnt){
        System.out.printf(NUMBER_OF_USER_GAME_COUNT.getMessage(), userGameCnt);
    }

    public static void printRandomNumbers(List<List<Integer>> randomNumbers) {
        randomNumbers.stream()
                .forEach(numbers-> System.out.println(numbers));
    }

    public static void printResult(int[] resultArray){
        System.out.printf(START_OF_RESULT_MESSAGE.getMessage());
        System.out.printf(RESULT_OF_VALUE_MESSAGE.getMessage(),3,THREE.getMessage(),resultArray[1]);
        System.out.printf(RESULT_OF_VALUE_MESSAGE.getMessage(),4,FOUR.getMessage(),resultArray[2]);
        System.out.printf(RESULT_OF_VALUE_MESSAGE.getMessage(),5,FIVE.getMessage(),resultArray[3]);
        System.out.printf(RESULT_OF_BONUS_VALUE_MESSAGE.getMessage(),5,FIVE_BONUS.getMessage(),resultArray[4]);
        System.out.printf(RESULT_OF_VALUE_MESSAGE.getMessage(),6,SIX.getMessage(),resultArray[5]);
    }

    public static void printRateOfReturn(int userPrice,int resultSum){
        double rateOfReturn=(double)Math.round((((double)resultSum)/(double)userPrice)*1000.0)/10;
        System.out.printf(RATE_OF_RETURN_MESSAGE.getMessage(),rateOfReturn);
    }
}
