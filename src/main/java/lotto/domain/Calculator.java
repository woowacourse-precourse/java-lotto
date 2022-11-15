package lotto.domain;

import java.util.List;

public class Calculator {
    private static List<Integer> numbers;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static int reward;
    private static int rank;
    private static final int NUMBER_LENGTH = 6;
    
    public Calculator(Lotto lotto, NumberGenerator ng) {
        numbers = lotto.getNumbers();
        winningNumbers = ng.getNumbers();
        bonusNumber = ng.getBonusNumber();
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
        rank = lottoRank.ordinal();
        LottoReward lottoReward = LottoReward.findByName(lottoRank.getRank());
        reward = lottoReward.getReward();
    }
    
    public int getRank() {
        return rank;
    }
    
    public int getReward() {
        return reward;
    }
}
