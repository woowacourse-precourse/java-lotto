package lotto;

import java.util.List;

public class Calculator {

    private static final int LOTTO_PRICE = 1000;



    public static int countLotto(int price){


        return price/LOTTO_PRICE;

    }

    public static double CalculateRate(List<Lotto> lottos, Lotto winningLotto,int bonus){

        List<Integer> WinningNumbers = winningLotto.getNumbers();

        int totalPrize = getTotalPrize(lottos, WinningNumbers, bonus);
        double rate = 0;

        rate = ((totalPrize*1.0)/(lottos.size()*1000))*100;

        return Math.round(rate*100)/100.0;

    }

    public static int getTotalPrize(List<Lotto> lottos, List<Integer> WinningNumbers,int bonus){

        int totalPrize = 0;

        for(Lotto lotto : lottos){
            int cnt = lotto.countMatchedNumbers(WinningNumbers);
            boolean isBonusmatched = lotto.checkBonusMatched(bonus,cnt);
            Rank rank = lotto.getRank(WinningNumbers,isBonusmatched);
            rank.setCount(rank.getCount()+1);
//            System.out.println("cnt = " + cnt);
//            System.out.println("isBonusmatched = " + isBonusmatched);
//            System.out.println("rank = " + rank);

            totalPrize += rank.getPrize();
        }

        return totalPrize;
    }








}
