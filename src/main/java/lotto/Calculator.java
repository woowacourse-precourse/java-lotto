package lotto;

import java.util.List;

public class Calculator {

    private static final int LOTTO_PRICE = 1000;
    private static final int bonusNumIdx = 6;


    public static int countLotto(int price){

        validate(price);
        return price/LOTTO_PRICE;

    }

    public static double CalculateRate(List<Lotto> lottos, List<Integer> winningNums){

        int totalPrize = 0;
        double rate = 0;

        for(Lotto lotto : lottos){
            int cnt = lotto.countMatchedNumbers(winningNums);
            boolean isBonusmatched = lotto.checkBonusMatched(winningNums.get(bonusNumIdx),cnt);
            Rank rank = lotto.getRank(winningNums);
//            System.out.println("cnt = " + cnt);
//            System.out.println("isBonusmatched = " + isBonusmatched);
//            System.out.println("rank = " + rank);

            totalPrize += rank.getPrize();
        }

        rate = ((totalPrize*1.0)/(lottos.size()*1000))*100;

        return Math.round(rate*100)/100.0;

    }





    private static void validate(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이여야 합니다.");
        }
    }


}
