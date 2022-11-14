package lotto.view;

import lotto.domain.Award;
import lotto.system.Constant;
import lotto.system.IOMessage;
import lotto.util.Util;

import java.util.Collections;
import java.util.List;

public final class OutputView {
    private OutputView() {
    }

    public static void printReward(List<Award> awards) {
        printIOMessage("3개 일치 (5,000원) - " + Collections.frequency(awards, Award.THREE) + "개");
        printIOMessage("4개 일치 (50,000원) - " + Collections.frequency(awards, Award.FOUR) + "개");
        printIOMessage("5개 일치 (1,500,000원) - " + Collections.frequency(awards, Award.FIVE) + "개");
        printIOMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(awards, Award.FIVE_BONUS) + "개");
        printIOMessage("6개 일치 (2,000,000,000원) - " + Collections.frequency(awards, Award.SIX) + "개");
    }

    public static void printYield(float yield) {
        String formattedYield = Util.makeFloatFormatted(yield, Constant.PRECISION);
        printIOMessage("총 수익률은 " + formattedYield + "%입니다.");
    }

    public static void printLotto(List<Integer> lotto) {
       System.out.println(lotto);
    }

    public static void printReceipt(int size) {
        System.out.println(size + IOMessage.WRITE_AMOUNT_MESSAGE);
    }

    public static void printIOMessage(String message) {
        System.out.println(message);
    }
}
