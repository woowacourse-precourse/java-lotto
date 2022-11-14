package game;

import java.util.List;

public class Calculate {
    public int grade(List<Integer> lotto, List<Integer> input, int bonus) {
        int cnt = 0;

        for (int i = 0; i < input.size(); i ++) {
            if (lotto.contains(input.get(i))) cnt++;
            if (cnt==5 && lotto.contains(bonus)) return 30_000_000;
        }

        if (cnt==6) return 2_000_000_000;
        if (cnt==5) return 1_500_000;
        if (cnt==4) return 50_000;
        if (cnt==3) return 5_000;
        return 0;
    }


    // TODO 수익률을 계산하는 기능 구현
    public int EarningRate(int lottoCnt, List<Integer> lotto, List<Integer> usersLotto) {
        return 0;
    }
}
