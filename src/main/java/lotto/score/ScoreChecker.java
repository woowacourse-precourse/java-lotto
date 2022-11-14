package lotto.score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.publisher.Lotto;
import lotto.publisher.WinnerLotto;

public class ScoreChecker {

    public Score getMyScore(List<Lotto> myLottos, WinnerLotto winnerLotto) {
        Map<Grade, Integer> grades = new HashMap<>();

        for (Grade i : Grade.values()) {
            grades.put(i, 0);
        }

        for (Lotto i : myLottos) {
            int winCount = getWinCount(i, winnerLotto);
            int bonusCount = getBonusCount(i, winnerLotto);

            getProperGrades(winCount, bonusCount)
                    .ifPresent(grade -> grades.put(grade, grades.get(grade) + 1));
        }

        double rewardPercentage = getRewardPercentage(myLottos, grades);

        return new Score(grades, rewardPercentage);
    }

    private int getWinCount(Lotto myLotto, WinnerLotto winnerLotto) {
        return (int) winnerLotto.getWinningLotto().getNumbers()
                .stream()
                .filter(j -> myLotto.getNumbers().contains(j))
                .count();
    }

    private int getBonusCount(Lotto myLotto, WinnerLotto winnerLotto) {
        if (myLotto.getNumbers().contains(winnerLotto.getBonusNumber())) {
            return 1;
        }

        return 0;
    }

    private Optional<Grade> getProperGrades(long userHitCount, long bonusNumberCount) {

        for (Grade i : Grade.values()) {
            if (i.getCorrectCount() == userHitCount && i.getBonusCount() == bonusNumberCount) {

                return Optional.of(i);
            }
        }

        return Optional.empty();
    }


    private double getRewardPercentage(List<Lotto> myLottos, Map<Grade, Integer> grades) {
        int budget = myLottos.size() * 1000;
        int reward = 1;

        for (Grade i : grades.keySet()) {
            reward += i.getReward() * grades.get(i);
        }

        if (reward == 1) {
            return 0D;
        }

        return reward / (double) budget * 100;
    }

}
