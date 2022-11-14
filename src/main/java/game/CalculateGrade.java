package game;

import java.util.List;

public class CalculateGrade {
    public int grade(List<Integer> lotto, List<Integer> input, int bonus) {
        int cnt = 0;

        for (int i = 0; i < input.size(); i ++) {
            if (lotto.contains(input.get(i))) cnt++;
            if (cnt==5 && lotto.contains(bonus)) return 2;
        }

        if (cnt==6) return 1;
        if (cnt==5) return 3;
        if (cnt==4) return 4;
        if (cnt==3) return 5;
        return 0;
    }
}
