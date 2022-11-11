package lotto;

public class Calculator {
    public int getLottoCount(int money) {
        return money / 1000;
    }

    public Rank calculateRank(int correctCount, boolean bonus) {
        if (correctCount != 5) {
            bonus = false;
        }
        return Rank.findByCorrectCountAndBonus(correctCount, bonus);
    }
}
