package lotto.view;

import lotto.domain.GameSet;
import lotto.domain.LottoProperties;

import static lotto.domain.Lotto.SECOND_WINNER_COUNT;


public class OutputLotto {
    public static void printResult(GameSet gameSet){
        System.out.println("당첨 통계");
        System.out.println("---");
        int cnt = 0;
        int[] gameCount = gameSet.getGameCount();
        for(LottoProperties name:LottoProperties.values()){
            if (name.getCorrect()==-1){
                break;
            }
            if (name.getCorrect()==SECOND_WINNER_COUNT){
                System.out.println(name.getCorrect()-2+"개 일치, 보너스 볼 일치 ("+name.getSprice()+") - "+gameCount[cnt++]+"개");
                continue;
            }
            System.out.println(name.getCorrect()+"개 일치 ("+name.getSprice()+") - "+gameCount[cnt++]+"개");
        }
        double result = 0;
        if (gameSet.getTotalPrize()!=0) {
            result =  (double)gameSet.getTotalPrize()/((double)gameSet.getLottoCount()*1000);
        }
        System.out.println("총 수익률은 "+ result*100+"%입니다.");
    }
}
