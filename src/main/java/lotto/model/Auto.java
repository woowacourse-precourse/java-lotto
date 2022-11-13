package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Auto {

    public static List<List<Integer>> AUTO_LOTTOS = new ArrayList<>();
    public static List<Integer> WINNING_NUMBERS = new ArrayList<>();
    public static int FIRST ;
    public static int SECOND ;
    public static int THIRD ;
    public static int FOURTH ;
    public static int FIFTH ;

    public Auto() {}
    public Auto(int lottoCount) {
        for(int i=0; i<lottoCount; i++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            AUTO_LOTTOS.add(lotto);
        }
    }

    public void makeWinningNumbers(String userInput) {
        List<String> userInputs = Arrays.asList(userInput.split(","));
        for(String userNumber : userInputs){
            WINNING_NUMBERS.add(Integer.parseInt(userNumber));
        }
    }

    public void checkWining(int bonusNumber) {
        for(List<Integer> autoLotto :  AUTO_LOTTOS){
            int win = countWin(autoLotto);
            int bonusWin = 0;

            if(autoLotto.contains(bonusNumber)){
                bonusWin++;
            }
            countWinningResult(win, bonusWin);
        }
    }

    private int countWin(List<Integer> autoLotto) {
        int win = 0;
        for(int winningNumber : WINNING_NUMBERS){
            if(autoLotto.contains(winningNumber)){
                win++;
            }
        }
        return win;
    }

    private void countWinningResult(int win, int bonusWin) {
        if(win==6) FIRST++;
        if(win==5 && bonusWin==1) SECOND++;
        if(win==5) THIRD++;
        if(win==4) FOURTH++;
        if(win==3) FIFTH++;
    }
}
