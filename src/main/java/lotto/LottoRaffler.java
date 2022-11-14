package lotto;

import constants.Rank;

import java.util.List;

public class LottoRaffler {

    private Integer[] winningNumbers = null;

    private Integer bonusNumber = null;


    public LottoRaffler(Integer[] winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void raffle(List<Lotto> lottos, LottoRaffler raffler) {
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getNumbers();
            int i1 = 0;
            for (int j = 0; j < lottoNumbers.size(); j++) {
                i1 += raffler.checkMatches(lottoNumbers.get(j));
            }
            System.out.println(Rank.getRank(i1));
            System.out.println(i1);
        }
    }


    public int checkMatches(int lottoNumber) {

        int cnt = 0;

        for (int i = 0; i < winningNumbers.length; i++) {
            if(winningNumbers[i]==lottoNumber){
                cnt++;
            }
        }
        return cnt;
    }

}
