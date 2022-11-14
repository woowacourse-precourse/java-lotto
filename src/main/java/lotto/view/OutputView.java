package lotto.view;

import java.util.HashMap;
import lotto.model.Buyer;
import lotto.model.LottoStatics;
import lotto.model.Winning;

public class OutputView {
    private static final String MESSAGE_STATICS_START = "당첨 통계\n---\n";
    private static final String MESSAGE_STATICS_INFO = "%s (%,d원) - %d개\n";
    private static final String MESSAGE_YIELD = "총 수익률은 %.1f%%입니다.";


    public static void printStatics(LottoStatics statics) {
        HashMap<Winning, Integer> staticsInfo = statics.getStaticsInfo();
        
        System.out.printf(MESSAGE_STATICS_START);
        for (Winning value : Winning.values()) {
            if (value.getPrize() != 0) {
                System.out.printf(MESSAGE_STATICS_INFO, value.getDetail(), value.getPrize(), staticsInfo.get(value));
            }
        }
    }

    public static void printYield(Buyer buyer, LottoStatics statics) {
        float yield = (statics.getTotalPrize() / (float) buyer.getMoney()) * 100;
        System.out.printf(MESSAGE_YIELD, yield);
    }
}
