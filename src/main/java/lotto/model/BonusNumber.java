package lotto.domain;

import lotto.Compare;

import java.util.HashMap;
import java.util.List;

public class BonusNumber {
    public static int bonusNumber;
    public static HashMap<Integer, Boolean> hasBonusNumber;
    public static boolean hasOrNot;
    public static List<Integer> userList = InputNumber.winNumbers;
    public static HashMap<Integer, List<Integer>> randomLottos = Compare.randomLottos;

    public static void compare(){
        int numberOfLottos = Money.numberOfLottos;
        hasBonusNumber = new HashMap<>();
        for (int i = 0; i < numberOfLottos; i++) {
            hasOrNot = contain(i);
            hasBonusNumber.put(i,hasOrNot);
        }
    }

    private static boolean contain(int index) {
        List<Integer> check = randomLottos.get(index);
        bonusNumber = InputNumber.bonusNumber;
        hasOrNot = false;
        for (int j = 0; j < userList.size(); j++) {
            if(check.contains(bonusNumber)){
                return true;
            }
        }
        return false;
    }


}
