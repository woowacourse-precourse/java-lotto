package lotto.domain;

import java.util.*;

public class Lucky {
    public List<Integer> compareNumbers(List<List<Integer>> user, List<Integer> com, int bonusNumber) {
        List<Integer> compareNumbers = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            int count = 0;
            for (int j = 0; j < user.get(i).size(); j++) {
                int num = user.get(i).get(j);
                if (com.contains(num)) {
                    count++;
                }
            }
            if (count == 5) {
                count += compareBonus(user.get(i),bonusNumber);
            }
            if (count > 2) {
                compareNumbers.add(count);
            }
        }
        return compareNumbers;
    }

    public int compareBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 2;
        }
        return 0;
    }
}
