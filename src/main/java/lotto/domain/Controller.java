package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Controller {
    private static final String NUMERIC_STRING_ERROR_MESSAGE = "숫자 형식으로 입력해 주세요.";

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void run(){
    }

    private int inputPurchaseAmount(){
        return 0;
    }

    private int formatStringToNumber(String number){
        return 0;
    }

    private void checkNumericString(String number){
        if(!number.chars().allMatch(Character::isDigit)){
            Logger.log(NUMERIC_STRING_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkDivisibleThousand(int number){
    }

    private void printPublishedLotto(List<Lotto> lottos){

    }

    private List<Integer> calculateWonLotto(List<Lotto> lottos){
        return null;
    }

    private void printWonLotto(List<Integer> rankCounts){
    }

    private void printYield(int loss, int profit){
    }
}
