package lotto;

import java.util.List;

public class Calculator {

    private static final int LOTTO_PRICE = 1000;



    public static int countLotto(int price){

        Validate.validatePrice(price);
        return price/LOTTO_PRICE;

    }

    public static double CalculateRate(List<Lotto> lottos, Lotto winningLotto,int bonus){

        int totalPrize = 0;
        double rate = 0;

        List<Integer> WinningNumbers = winningLotto.getNumbers();

        for(Lotto lotto : lottos){
            int cnt = lotto.countMatchedNumbers(WinningNumbers);
            boolean isBonusmatched = lotto.checkBonusMatched(bonus,cnt);
            Rank rank = lotto.getRank(WinningNumbers);
            rank.setCount(rank.getCount()+1);
            System.out.println("cnt = " + cnt);
            System.out.println("isBonusmatched = " + isBonusmatched);
            System.out.println("rank = " + rank);

            totalPrize += rank.getPrize();
        }

        rate = ((totalPrize*1.0)/(lottos.size()*1000))*100;

        return Math.round(rate*100)/100.0;

    }








}
