package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<List<Integer>> purchasedLottos;
    private final List<Integer> winningNum;
    private final int bonusNum;


    public Calculator(List<List<Integer>> purchasedLottos, List<Integer> winningNum, int bonusNum) {
        this.purchasedLottos = List.copyOf(purchasedLottos);
        this.winningNum = List.copyOf(winningNum);
        this.bonusNum = bonusNum;
    }

    /**
     * Return the number of correct numbers which is bigger than 3
     * @return resultList
     */
    public List<Integer> calculateCorrectNum() {
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> lotto : purchasedLottos) {
            List<Integer> correctNumbers = winningNum.stream().filter(x -> lotto.contains(x))
                    .collect(Collectors.toList());
            if (correctNumbers.size() == 5 && isBonusCorrect(lotto)) {
                resultList.add(-1);
                continue;
            }
            if (correctNumbers.size() >= 3) {
                resultList.add(correctNumbers.size());
            }
        }
        return resultList;
    }

    /**
     * Check if bonus number is included in lotto number
     * @param lotto number list of single lotto ticket
     * @return whether bonus number is included
     */
    public boolean isBonusCorrect(List<Integer> lotto) {
        return lotto.contains(bonusNum);
    }
}
