package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Scores {
    private List<Integer> scores;

    public Scores() {
        scores = Arrays.asList(0,0,0,0,0);
    }


    public void compare(UserLottos userLottos, Lotto winningNum, Bonus bonus) {
        userLottos.getUserLottos().stream().forEach(lotto -> {
            Integer duplicateNum = getDuplicateNum(lotto,winningNum);
            checkFirst(duplicateNum);
            checkSecond(duplicateNum,lotto,bonus.getNum());
            checkThird(duplicateNum);
            checkForth(duplicateNum);
            checkFifth(duplicateNum);
        });
    }

    private void checkFifth(Integer duplicateNum) {
        if (duplicateNum == 3) {
            setScores(Score.FIFTH);
        }
    }

    private void checkForth(Integer duplicateNum) {
        if (duplicateNum == 4) {
            setScores(Score.FORTH);
        }
    }

    private void checkThird(Integer duplicateNum) {
        if (duplicateNum == 5) {
            setScores(Score.THIRD);
        }
    }

    private void checkSecond(Integer duplicateNum, Lotto lotto, Integer bonus) {
        if (duplicateNum == 5 && lotto.getNumbers().contains(bonus)) {
            setScores(Score.SECOND);
        }
    }

    private void checkFirst(Integer duplicateNum) {
        if (duplicateNum == 6) {
            setScores(Score.FIRST);
        }
    }

    private Integer getDuplicateNum(Lotto lotto, Lotto winninNum) {
        Integer duplicateNum = (int) lotto.getNumbers().stream()
                .filter(old -> winninNum.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(old))).count();
        return duplicateNum;
    }

    private void setScores(Score score) {
        Integer before = this.scores.get(score.ordinal());
        this.scores.set(score.ordinal(),before+1);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public Integer getSumofScores() {
        Integer sumOfScores  = 0;
        for (Score value : Score.values()) {
            sumOfScores += (this.scores.get(value.ordinal())*value.getMoney());
        }
        return sumOfScores;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "scores=" + scores +
                '}';
    }
}
