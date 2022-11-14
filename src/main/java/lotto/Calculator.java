package lotto;

import java.util.List;

public class Calculator {
    int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
    int bonus, cnt = 0;

    private final List<List<Integer>> lottoLists;
    private final List<Integer> winningLotto;

    public Calculator(List<List<Integer>> lottoLists, List<Integer> winningLotto) {
        this.lottoLists = lottoLists;
        this.winningLotto = winningLotto;
        bonus = winningLotto.get(6);
        winningLotto.remove(6);
    }

    public List<Integer> getResult() {
        for (List<Integer> lottoList : lottoLists) {
            cnt = 0;
            for (Integer winningNumber : winningLotto) {
                countCalculator(lottoList, winningNumber);
            }
            rankCalculator();
        }
        return List.of(first, second, third, fourth, fifth);
    }

    public void countCalculator(List<Integer> lottoList, Integer winningNumber) {
        if (lottoList.contains(winningNumber)) {
            cnt += 1;
        }
    }

    public void rankCalculator() {
        if (cnt == 6) first += 1;
        if (cnt == 5) {
            if (lottoLists.contains(bonus)){
                second += 1;
            }
            else third += 1;
        }
        if (cnt == 4) fourth += 1;
        if (cnt == 3) fifth += 1;
    }
}
