package lotto;

import java.util.List;
import java.util.Objects;

public class Calculation {
    private static final int LOTTO_LENGTH = 6;

    public static void calculateWinningDetails(Purchaser purchaser, Lotto lotto){
        for(Lotto receviedLotto: purchaser.numbers){
            checkHit(receviedLotto.getNumbers(), lotto);
        }
    }

    public static void checkHit(List number, Lotto lotto){
        int hitNumber = 0;

        for(int i=0; i<LOTTO_LENGTH; ++i){
            if(lotto.getNumbers().contains(number.get(i))){
                ++hitNumber;
            }
        }
        if (hitNumber==6){
            WinningResult.FIRST.increaseNumOfWins();
        }
        // 5개가 맞는 경우
        if (hitNumber==5){
            getFifthOrFourth(number);
        }
        if (hitNumber==4){
            WinningResult.FOURTH.increaseNumOfWins();
        }
        if (hitNumber==3){
            WinningResult.FIFTH.increaseNumOfWins();
        }
    }

    public static void getFifthOrFourth(List number){
        if(number.contains(Lotto.bonusNumber)){
            WinningResult.SECOND.increaseNumOfWins();
        }
        if(!number.contains(Lotto.bonusNumber)){
            WinningResult.THIRD.increaseNumOfWins();
        }
    }

    public static long calculateTotalEarns(Purchaser purchaser, Lotto lotto){
        long totalEarns = 0;

        for(WinningResult result: WinningResult.values()){
            totalEarns += result.earning();
        }
        return totalEarns;
    }
}
