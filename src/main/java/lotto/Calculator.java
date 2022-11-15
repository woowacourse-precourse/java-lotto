package lotto;

import java.util.List;

public class Calculator {

    private static final int LOTTO_PRICE = 1000;



    public static int countLotto(int price){

        return price/LOTTO_PRICE;

    }

    public static double CalculateRate(List<Lotto> lottos, Lotto winningLotto,int bonus){

        int totalPrize = getTotalPrize(lottos, winningLotto, bonus);
        double rate = 0;

        rate = ((totalPrize*1.0)/(lottos.size()*1000))*100;

        return Math.round(rate*100)/100.0;

    }

    public static int getTotalPrize(List<Lotto> lottos, Lotto winningLotto,int bonus){

        int totalPrize = 0;
        List<Integer> WinningNumbers = winningLotto.getNumbers();

        for(Lotto lotto : lottos){
            int cnt = lotto.countMatchedNumbers(WinningNumbers);
            boolean isBonusmatched = lotto.checkBonusMatched(bonus,cnt);
            Rank rank = lotto.getRank(cnt,isBonusmatched);
            rank.setCount(rank.getCount()+1);

            totalPrize += rank.getPrize();
        }

        return totalPrize;
    }








}
