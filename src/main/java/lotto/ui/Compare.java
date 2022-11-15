package lotto.ui;

import java.util.List;

public class Compare {
    public int same = 0;
    public Compare(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < 6; i++) {
            if (computer.contains(user.get(i))) {
                same++;
            }
        }
    }
    public int getSame() {
        return same;
    }
}
