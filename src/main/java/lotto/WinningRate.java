package lotto;

import java.util.List;

public class WinningRate {
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
    public static int calculateYeild(List<String> currentLotto, int payedPrice){
        int yeild = 0;
        for(int i = 0; i< currentLotto.size(); i++){
            yeild += Integer.parseInt(currentLotto.get(i)) * getPrice(i);
        }
        return (yeild - payedPrice) / payedPrice * 100;
    }
}
