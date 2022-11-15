package lotto.view;

import lotto.domain.Lotto;
import lotto.enums.Message;
import lotto.enums.Range;
import lotto.enums.StatisticMessage;
import org.mockito.internal.util.StringUtil;

import java.util.List;

public class OutputView {

    public static void askPrice(){
        System.out.println(Message.PRICE_ASK.getMessage());
    }

    public static void printQuantity(int n, List<Lotto> lottos){
        System.out.println(n+Message.OUT_QUANTITY.getMessage());
        for (Lotto lotto: lottos){
            System.out.println(StringUtil.join(lotto.getNumbers()));
        }
    }

    public static void askWinNum(){
        System.out.println(Message.NUM_ASK.getMessage());
    }

    public static void askBonusNum(){
        System.out.println(Message.BONUS_ASK.getMessage());
    }

    public static void printStatistic(int[] correct, double earn){
        System.out.println(Message.OUT_STATISTIC.getMessage());
        for (int i=0;i< Range.CORRECT_CASE.get();i++){
            System.out.println(StatisticMessage.printIdx(i).getMessage()+correct[i]+"개");
        }
        System.out.println(Message.REVENUE.getMessage()+earn+"입니다.");
    }

}
