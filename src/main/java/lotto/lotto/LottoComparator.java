package lotto.lotto;

import java.util.List;

public class LottoComparator {

    public static int getMatchedNumbers(List<Integer> winner, List<Integer> user) {
        int counter = 0;
        for(int i = 0 ; i < winner.size() - 1; i++) {
            for (int j = 0; j < user.size(); j++) {
                if (winner.get(i).equals(user.get(j)))
                    counter += 1;
            }
        }

        return (counter);
    }

    public static boolean isBonusMatched(List<Integer> winner, List<Integer> user) {
        for(Integer userBall : user) {
            if (userBall.equals(winner.get(winner.size() - 1)))
                return true;
        }
        return false;
    }
}
