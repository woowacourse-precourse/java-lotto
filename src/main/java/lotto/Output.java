package lotto;

import java.util.HashMap;
import java.util.List;

public class Output {
    public static final String BLANK_LINE = "";
    public static final String PURCHASE_EVENT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String AFTER_PURCHASE_EVENT_MESSAGE = "개를 구매했습니다.";
    public static final String WIN_NUMBER_EVENT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_EVENT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WIN_RECORD_TITLE = "당첨 통계\n---";
    public static final String PROFIT_EVENT_MESSAGE = "총 수익률은 $profit%입니다.";
    public static final String REPLACE_PROFIT_FROM = "$profit";

    public static void blankLine() {
        System.out.println(BLANK_LINE);
    }

    public static void purchaseEventMessage() {
        System.out.println(PURCHASE_EVENT_MESSAGE);
    }

    public static void numberOfPurchaseEventMessage(int number) {
        System.out.println(number + AFTER_PURCHASE_EVENT_MESSAGE);
    }

    public static void issuedLottosEventMessage(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void winNumberEventMessage() {
        System.out.println(WIN_NUMBER_EVENT_MESSAGE);
    }

    public static void bonusNumberEventMessage() {
        System.out.println(BONUS_NUMBER_EVENT_MESSAGE);
    }

    public static void winRecordEventMessage(HashMap<String, Integer> winRecords) {
        System.out.println(WIN_RECORD_TITLE);

        for (LottoWinType winType : LottoWinType.values()) {
            String winMessage = winType.getEventMessage();
            int winNumber = winRecords.get(winType.getKey());
            String replaceFrom = "$";
            replaceFrom = replaceFrom.concat(winType.getKey());
            winMessage = winMessage.replace(replaceFrom, Integer.toString(winNumber));

            System.out.println(winMessage);
        }
    }

    public static void profitEventMessage(float profit) {
        System.out.println(PROFIT_EVENT_MESSAGE.replace(REPLACE_PROFIT_FROM, String.format("%.1f", profit)));
    }
}