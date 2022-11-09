package lotto.service;

import lotto.Lotto;
import lotto.view.LottoIO;
import lotto.view.UserIO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchLogic {

    LottoIO answer;
    UserIO user;
    private List<Integer> matchNums = Stream.of(0, 0, 0, 0, 0).collect(Collectors.toList());
    private List<Long> priceList = Stream.of(2000000000L, 30000000L, 1500000L, 50000L, 5000L).collect(Collectors.toList());

    public MatchLogic(LottoIO answer, UserIO user) {
        this.answer = answer;
        this.user = user;
    }

    // 당첨 통계 로직
    public void countMatches() {
        for (Lotto userLotto : user.getUserLottoList()) {
            int answerMatch = answerMatch(userLotto.getNumbers(), answer.getLottoAnswer());
            boolean bonusMatch = bonusMatch(userLotto.getNumbers(), answer.getBonus());

            if (answerMatch == 6) { // 1등
                Integer val = matchNums.get(0);
                matchNums.set(0, val + 1);
                continue;
            }
            if (answerMatch == 5 && bonusMatch) { // 2등
                Integer val = matchNums.get(1);
                matchNums.set(1, val + 1);
                continue;
            }
            if (answerMatch == 5) { // 3등
                Integer val = matchNums.get(2);
                matchNums.set(2, val + 1);
                continue;
            }
            if (answerMatch == 4) { // 4등
                Integer val = matchNums.get(3);
                matchNums.set(3, val + 1);
                continue;
            }
            if (answerMatch == 3) { // 5등
                Integer val = matchNums.get(4);
                matchNums.set(4, val + 1);
                continue;
            }
        }
    }

    // 특정 로또와 정답 로또 비교
    private int answerMatch(List<Integer> userLotto, List<Integer> answerLotto) {
        int count = 0;
        for (Integer ans : answerLotto) {
            if (userLotto.contains(ans)) {
                count++;
            }
        }
        return count;
    }

    // 특정 로또와 보너스 번호 비교
    private boolean bonusMatch(List<Integer> userLotto, int bonus) {
        if (userLotto.contains(bonus)) {
            return true;
        }
        return false;
    }

}
