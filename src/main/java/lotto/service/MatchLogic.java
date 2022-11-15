package lotto.service;

import lotto.Lotto;
import lotto.view.LottoIO;
import lotto.view.UserIO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchLogic {

    LottoIO answer;
    UserIO user;
    private List<Integer> matchNums = Stream.of(0, 0, 0, 0, 0).collect(Collectors.toList());

    public MatchLogic(LottoIO answer, UserIO user) {
        this.answer = answer;
        this.user = user;
    }

    // 당첨 통계 로직
    public void countMatches() {
        for (Lotto userLotto : user.getUserLottoList()) {
            int answerMatch = answerMatch(userLotto.getNumbers(), answer.getLottoAnswer());
            boolean bonusMatch = bonusMatch(userLotto.getNumbers(), answer.getBonus());
            Optional<Statistics> rank = Statistics.getRank(answerMatch, bonusMatch);

            // 등수 내로 들지 못한 경우
            if (rank.isEmpty()) {
                continue;
            }
            // 1-5등 로직
            Statistics result = rank.get();
            setWinner(result.getIndex());
        }
    }

    // 1-5등 정보 갱신
    public void setWinner(int index) {
        matchNums.set(index, matchNums.get(index) + 1);
    }

    // 특정 로또와 정답 로또 비교
    public int answerMatch(List<Integer> userLotto, List<Integer> answerLotto) {
        int count = 0;
        for (Integer ans : answerLotto) {
            if (userLotto.contains(ans)) {
                count++;
            }
        }
        return count;
    }

    // 특정 로또와 보너스 번호 비교
    public boolean bonusMatch(List<Integer> userLotto, int bonus) {
        if (userLotto.contains(bonus)) {
            return true;
        }
        return false;
    }

    // 총 수익률 계산
    public double computeYields(int budget) {
        Long yields = 0L;
        double result = 0;
        for (int i = 0; i < this.matchNums.size(); i++) {
            int cnt = matchNums.get(i);
            Long value = cnt * Statistics.values()[i].getPrice();
            yields += value;
        }
        result = yields / (double) budget * 100;
        return Math.round(result * 10.0) / 10.0;
    }

    public List<Integer> getMatchNums() {
        return this.matchNums;
    }

}
