package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyLotto {
    private final List<Integer> mynumbers;

    public MyLotto(List<Integer> mynumbers) {
        validate(mynumbers);
        random(mynumbers);
        duplicate(mynumbers);
        this.mynumbers = mynumbers;
    }

    private void validate(List<Integer> mynumbers) {
        if (mynumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void random(List<Integer> mynumbers) {
        Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> duplicate(List<Integer> mynumbers){
        HashSet<Integer> checkmynumbers = new HashSet<Integer>(mynumbers);
        return new ArrayList<Integer>(checkmynumbers);
    }
}
