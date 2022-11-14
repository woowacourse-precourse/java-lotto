package lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker {

    //몇개가 일치하는지 계산
    public static List<Integer> winningNumber = new ArrayList<>();
    public static int bonusNumber;
    public static List<List<Integer>> myNumber = new ArrayList<>();
    public static List<Integer> numberOfCorrectNumbers = new ArrayList<>();
    public static List<Integer> ranks = new ArrayList<>();

    NumberChecker(List<Integer> winningNumber, int bonusNumber, List<List<Integer>> myNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.myNumber = myNumber;
    }

    public static void compareNumber() {
        for (int i = 0; i < myNumber.size(); i++) {
            List<Integer> compareTemp = new ArrayList<>();
            compareTemp.addAll(winningNumber);
            compareTemp.retainAll(myNumber.get(i));
            numberOfCorrectNumbers.add(compareTemp.size());
        }
    }

    public static boolean checkBonus() {
        for (List<Integer> myLotto : myNumber) {
            if (myLotto.contains(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> countRanks() {
        PrizeEnum[] values = PrizeEnum.values();
        for (int i = 0; i < values.length; i++) {
            values[i].plusRankCount(numberOfCorrectNumbers);
        }
        return ranks;
    }

}
