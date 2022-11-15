package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.resources.Rank;

public enum Message {
    MONEY_MESSAGE("구입금액을 입력해 주세요."),
    ANNOUNCE_LOTTO_MESSAGE("\n%d개를 구매했습니다."),
    LOTTO_WINNER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_WINNER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    RESULT_MESSAGE("\n당첨 통계\n---"),
    STAT_MESSAGE("%d개 일치 (%s원) - %d개"),
    STAT_MESSAGE_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_MESSAGE_START("총 수익률은 %s%%입니다.");

    final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static List<String> printStat(Map<Integer, Integer> winnerResult, List<String> statOuts) {
        String outMessage;
        String sentence;
        int matchNum;
        int howMany;
        for (int i = winnerResult.size() - 1; i >= 0; i--) {
            outMessage = whichSentence(i);
            matchNum = Rank.getMatch(i);
            sentence = drawComma(Rank.getPrice(i));
            howMany = winnerResult.get(i);
            statOuts.add(String.format(outMessage, matchNum, sentence, howMany));
        }
        return statOuts;
    }

    public static String printPercent(double avg) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        return String.format(TOTAL_MESSAGE_START.getMessage(), df.format(Double.parseDouble(Double.toString(avg))));
    }

    public static String printAnnounce(long howManyLotto) {
        return String.format(ANNOUNCE_LOTTO_MESSAGE.getMessage(), howManyLotto);
    }

    private static String whichSentence(int i) {
        if (i == 1) {
            return STAT_MESSAGE_BONUS.getMessage();
        }
        return STAT_MESSAGE.getMessage();
    }

    private static String drawComma(long money) {
        return (new DecimalFormat("###,###")).format(money);
    }
}
