package lotto.domain;

import java.util.List;

public class Calculator {
    private static List<Integer> numbers;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static int reward;
    private static final int NUMBER_LENGTH = 6;
    
    public Calculator() {
        NumberGenerator numberGenerator = new NumberGenerator(1, 45, 6);
        Lotto lotto = new Lotto(numberGenerator.getNumbers());
        numbers = lotto.getNumbers();
        numberGenerator.setWinningNumber();
        winningNumbers = numberGenerator.getNumbers();
        bonusNumber = numberGenerator.getBonusNumber();
    }
    
    public void compareNumber() {
        int score = 0;
        int bonus = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            if(numbers.contains(winningNumbers.get(i))) {
                score++;
            }
        }
        if(numbers.contains(bonusNumber)) {
            bonus++;
        }
        LottoRank lottoRank = LottoRank.findByWinAndBonus(score, bonus);
        LottoReward lottoReward = LottoReward.findByName(lottoRank.getRank());
        reward = lottoReward.getReward();
    }
}
