package lotto.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningResult {

    public HashMap<Integer, Integer> cntwinning;

    public Map<Integer, Integer> getwinningResult(List<Lotto> lotto, List<Integer> winning, int bonus) {

    }

    private int rankFive(List<Lotto> lotto, List<Integer> winning) {
        int winningcnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> result = lotto.get(i).getNumbers().stream()
                    .filter(sign -> winning.stream().noneMatch(Predicate.isEqual(sign)))
                    .collect(Collectors.toList());
            if (result.size() == 3) {
                winningcnt++;
            }
        }
        return winningcnt;
    }

    private int rankFour(List<Lotto> lotto, List<Integer> winning) {
        int winningcnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> result = lotto.get(i).getNumbers().stream()
                    .filter(sign -> winning.stream().noneMatch(Predicate.isEqual(sign)))
                    .collect(Collectors.toList());
            if (result.size() == 2) {
                winningcnt++;
            }
        }
        return winningcnt;
    }

    private int rankThree(List<Lotto> lotto, List<Integer> winning) {
        int winningcnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> result = lotto.get(i).getNumbers().stream()
                    .filter(sign -> winning.stream().noneMatch(Predicate.isEqual(sign)))
                    .collect(Collectors.toList());
            if (result.size() == 1) {
                winningcnt++;
            }
        }
        return winningcnt;
    }

    private int rankTwo(List<Lotto> lotto, List<Integer> winning, int bonus) {
        int winningcnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> result = lotto.get(i).getNumbers().stream()
                    .filter(sign -> winning.stream().noneMatch(Predicate.isEqual(sign)))
                    .collect(Collectors.toList());
            if ((result.size() == 1) && lotto.get(i).getNumbers().contains(bonus)) {
                winningcnt++;
            }
        }
        return winningcnt;
    }

    private int rankOne(List<Lotto> lotto, List<Integer> winning) {
        int winningcnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> result = lotto.get(i).getNumbers().stream()
                    .filter(sign -> winning.stream().noneMatch(Predicate.isEqual(sign)))
                    .collect(Collectors.toList());
            if (result.size() == 0) {
                winningcnt++;
            }
        }
        return winningcnt;
    }


}
