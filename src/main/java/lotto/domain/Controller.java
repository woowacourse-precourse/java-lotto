package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class Controller {
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
