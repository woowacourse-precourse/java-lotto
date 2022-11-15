package lotto.message;

import java.util.LinkedHashMap;
import lotto.domain.place.MatchResult;

public class PrintMessage {
    public static final String formatTest = "%d개를 구매했습니다.";

    public static String createPurchaseQuantityMsg(int quantity) {
        return String.format(formatTest, quantity);
    }

    public static String createPlaceHistoryMsg(LinkedHashMap<MatchResult, Integer> matchResults) {
        StringBuffer stringBuffer = new StringBuffer();

        fillLines(matchResults, stringBuffer);

        return stringBuffer.toString();

    }

    private static void fillLines(LinkedHashMap<MatchResult, Integer> matchResults, StringBuffer stringBuffer) {
        matchResults.forEach((matchResult, value) -> appendLine(matchResults, stringBuffer, matchResult));
    }

    private static void appendLine(LinkedHashMap<MatchResult, Integer> matchResults, StringBuffer stringBuffer,
                                   MatchResult matchResult) {
        stringBuffer.append(createHistoryLine(matchResults, matchResult));
    }

    private static String createHistoryLine(LinkedHashMap<MatchResult, Integer> matchResults, MatchResult matchResult) {
        return String.format("%s - %d개\n", matchResult, matchResults.get(matchResult));
    }

}
