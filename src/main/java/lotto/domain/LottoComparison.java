package lotto.domain;

import lotto.Lotto;
import lotto.input.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoComparison {

    private final WinningNumber winningNumber;
    public LottoComparison(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Integer> findNumber(List<List<Integer>> randomLotto) {
        Lotto answer = winningNumber.getAnswer();
        List<Integer> winning = answer.getNumbers();
        System.out.println("당첨 번호: " + winning);
        System.out.println("------------");

        List<Integer> result = new ArrayList<>();

        for (List<Integer> random : randomLotto) {
            int cont = 0;

            for (int i = 0; i < winning.size(); i++) {
                int crrentNumber = winning.get(i);

                for (int j = 0; j < random.size(); j++) {
                    if (crrentNumber == random.get(j)) {
                        cont++;
                    }
                }
            }
            result.add(cont);
        }

        return result;
    }
}
