package lotto.domain;

import java.util.List;

public class Calculator {
    public static double calculateRateOfReturn(int[] result, int lottoCount){
        double rateOfReturn = (result[Rank.WINNING.getCount()] / lottoCount) / 10.0;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        return rateOfReturn;
    }
    public static int[] calculateRank(LottoTickets lottoTickets, Lotto winningLotto, int bonusNumber){
        List<Lotto> lottos = lottoTickets.getLottoTickets();
        int[] result = new int[8];
        for(int i = 0; i < lottos.size(); i++){
            Rank rank = Rank.getRank(lottos.get(i), winningLotto, bonusNumber);
            result[rank.getCount()]++;
            result[Rank.WINNING.getCount()] += rank.getWinnings();
        }
        return result;
    }
}
