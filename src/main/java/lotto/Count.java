package lotto;

import java.util.ArrayList;
import java.util.List;

public class Count {
    public static int[] BonusCount(List<List<Integer>> GeneratedLotto) {
        int[] count = new int[GeneratedLotto.size()];
        for (int i = 0; i < GeneratedLotto.size(); i++) {
            if (GeneratedLotto.get(i).contains(Bonus.BonusNumber)) {
                count[i] += 1;
            }
        }
        return count;
    }

    public static List<Integer> WinningCount(List<List<Integer>> GeneratedLotto, List<Integer> numbers) {
        List<Integer> counts = new ArrayList<>();
        int count;
        for (List<Integer> lotto : GeneratedLotto) {
            count = 0;
            count = WinCount(lotto, numbers);
            counts.add(count);
        }
        return counts;
    }

    public static int WinCount(List<Integer> lotto, List<Integer> numbers) {
        int count = 0;
        for (int j = 0; j < numbers.size(); j++) {
            if (lotto.contains(numbers.get(j))) {
                count++;
            }
        }
        return count;
    }

}
