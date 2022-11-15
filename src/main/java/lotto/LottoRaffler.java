package lotto;

import constants.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRaffler {

    private Integer[] winningNumbers = null;

    private Integer bonusNumber = null;

    private List<Rank> result = new ArrayList<>();

    public LottoRaffler(Integer[] winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> raffle(List<Lotto> lottos) {

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getNumbers();
            int matchCount = 0;
            boolean bonus = false;
            for (int j = 0; j < lottoNumbers.size(); j++) {
                matchCount += checkMatches(lottoNumbers.get(j));
                bonus = checkBonus(lottoNumbers.get(j));
            }
            addRaffleList(matchCount);

            if(matchCount==5&&bonus){
                result.add(Rank.BONUS);
            }
        }
        return result;
    }

    public boolean checkBonus(int lottoNumber){
        return bonusNumber == lottoNumber;
    }

    private void addRaffleList(int matchCount) {

        if (Rank.getRank(matchCount) != null&&Rank.getRank(matchCount)!=Rank.FIVE) {
            result.add(Rank.getRank(matchCount));
        }
    }


    public int checkMatches(int lottoNumber) {

        int cnt = 0;

        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] == lottoNumber) {
                cnt++;
            }
        }
        return cnt;
    }

}
