package lotto.service;

import lotto.domain.Policy;

import java.util.List;

public class ScoreService {

    public void countStatus(List<Integer> sameNumberCount) {
        initCount();
        for (int i = 0; i < sameNumberCount.size(); i++) {
            compare(sameNumberCount, i);
        }
    }

    private void compare(List<Integer> sameNumberList, int i) {
        for (int j = 0; j < Policy.match.size(); j++) {

            if (sameNumberList.get(i) == Policy.match.get(j)) {

                increaseCount(j);
            }
        }
    }

    public static void increaseCount(int index) {
        Integer num = Policy.count.get(index);
        num++;
        Policy.count.add(index, num);
        System.out.println(Policy.count.get(index));
    }

    private void initCount() {
        for (int i = 0; i < 4; i++) {
            Policy.count.add(0);
        }
    }
}
