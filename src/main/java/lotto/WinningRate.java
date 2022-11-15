package lotto;

import java.util.List;

public class WinningRate {
    private static int getLottoPrice(String prize){
        if(prize.matches("FIRST")){
            return 2000000000;
        } else if(prize.matches("SECOND")){
            return 30000000;
        } else if(prize.matches("THIRD")){
            return 1500000;
        } else if(prize.matches("FOURTH")){
            return 50000;
        } else if(prize.matches("FIFTH")){
            return 5000;
        }
        return 0;
    }
    private static int getPrice(int order){
        switch (order){
            case 1: return 5000;
            case 2: return 50000;
            case 3: return 1500000;
            case 4: return 30000000;
            case 5: return 2000000000;
            default: return 0;
        }
    }
    public static double calculateYeild(List<String> currentLotto, int payedPrice){
        double yeild = 0;
        for (String lotto : currentLotto) {
//            System.out.println(currentLotto.get(i));
            yeild += getLottoPrice(lotto);
        }
        return (yeild - payedPrice) / payedPrice * 100;
    }
}
