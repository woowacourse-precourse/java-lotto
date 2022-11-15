package lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker {

    //몇개가 일치하는지 계산
    public static List<Integer> winningNumber = new ArrayList<>();
    public static int bonusNumber;
    public static List<List<Integer>> myLottos = new ArrayList<>();

    NumberChecker(List<Integer> winningNumber, int bonusNumber, List<List<Integer>> myLottos) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.myLottos = myLottos;
    }

    public static int countCorrectNumbers(List<Integer> lotto) {
        List<Integer> compareTemp = new ArrayList<>();
        compareTemp.addAll(winningNumber);

        compareTemp.retainAll(lotto);

        return compareTemp.size();
    }

    public static boolean checkBonus(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public static void countRanks() {
        PrizeEnum[] values = PrizeEnum.values();
        for (int i = 0; i < myLottos.size(); i++) {
            for (int j = 0; j < values.length; j++) {
                values[j].plusRankCount(countCorrectNumbers(myLottos.get(i)), checkBonus(myLottos.get(i)));
            }
        }

    }
}
