package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Grade, Integer> gradeCount = new HashMap<>();
    private float earningRate;

    public Statistics(WinningNumbers winningNumbers, LottoGenerator lottoGenerator) {
        countGrade(winningNumbers, lottoGenerator.getLottos());
        calculateEarningRate(lottoGenerator.getNumberOfLotto());
    }

    private void countGrade(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Grade grade : Grade.values()) {
            gradeCount.put(grade, 0);
        }

        for (Lotto lotto : lottos) {
            int count = (int) lotto.getNumbers().stream().filter(v -> winningNumbers.getNumbers().contains(v)).count();
            Grade grade = getGrade(winningNumbers, lotto, count);
            gradeCount.put(grade, gradeCount.get(grade) + 1);
        }
    }

    private Grade getGrade(WinningNumbers winningNumbers, Lotto lotto, int count) {
        if (count == Grade.FIRST.getMatchCount()) {
            return Grade.FIRST;
        }
        if (count == Grade.SECOND.getMatchCount() && lotto.getNumbers().contains(winningNumbers.getBonus())) {
            return Grade.SECOND;
        }
        if (count == Grade.THIRD.getMatchCount() && !lotto.getNumbers().contains(winningNumbers.getBonus())) {
            return Grade.THIRD;
        }
        if (count == Grade.FOURTH.getMatchCount()) {
            return Grade.FOURTH;
        }
        if (count == Grade.FIFTH.getMatchCount()) {
            return Grade.FIFTH;
        }
        return Grade.NOTHING;
    }

    private void calculateEarningRate(int numberOfLotto) {
        float earning = calculateEarning();
        int purchaseAmount = numberOfLotto * LottoGenerator.LOTTO_PRICE;

        earningRate = earning / purchaseAmount * 100;
    }

    private float calculateEarning() {
        float earning = 0;

        for (Grade grade : Grade.values()) {
            int count = gradeCount.get(grade);
            if (count > 0) {
                earning += grade.getPrize() * count;
            }
        }

        return earning;
    }

    public Map<Grade, Integer> getGradeCount() {
        return gradeCount;
    }

    public float getEarningRate() {
        return earningRate;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(Message.STATISTICS_TITLE);

        Grade[] grades = Grade.values();
        for (int i = grades.length - 2; i >= 0; i--) {
            sb.append(grades[i].getCondition() + " (" + getCommaNumber(grades[i].getPrize()) + Unit.MONEY + ")" + " - " + gradeCount.get(grades[i]) + Unit.NUMBER + "\n");
        }

        sb.append(String.format("%s %.1f%s", Message.START_OF_EARNING_RATE, earningRate, Message.END_OF_EARNING_RATE));

        return sb.toString();
    }

    private String getCommaNumber(int number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        return decFormat.format(number);
    }
}
