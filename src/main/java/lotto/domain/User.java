package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    public List<List<Integer>> numbers = new ArrayList<>();;

    public List<List<Integer>> randomLotto(int price) {
        int number = price / 1000;

        for (int i=0; i<number; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            nums.sort(Comparator.naturalOrder());
            numbers.add(nums);
        }

        return numbers;
    }
}
