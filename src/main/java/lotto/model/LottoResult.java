package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoResult {
    enum Rank{
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5,1500000),
        FOURTH(4,50000),
        FIFTH(3,5000);

        final private int matches;
        final private int price;

        private Rank(int matches, int price){
            this.matches = matches;
            this.price = price;
        }

        public int getMatches() {
            return matches;
        }

        public int getPrice() {
            return price;
        }
    }

    private List<Integer> scoreBoard;
    private int winningAmount;

    public void setScoreBoard(List<List<Integer>> lottos, Set<Integer> winningNumbers){

    }

    public int compareLottoWinningNumber(List<Integer> lotto, Set<Integer> winningNumbers){
        int matches = 0;

        for (int number : lotto){
            if (winningNumbers.contains(number)){
                matches++;
            }
        }

        return matches;
    }

    public boolean compareLottoBonusNumber(List<Integer> lotto, int bonusNumber){
        return lotto.contains(bonusNumber);
    }

}
