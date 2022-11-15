package lotto.view;

import static lotto.value.CountValue.COUNT_DIVIDER;
import static lotto.value.CountValue.COUNT_UNIT;

import lotto.domain.place.MatchResult;
import lotto.domain.statistics.PlaceHistory;

public class PlaceHistoryMessage {

    private final PlaceHistory placeHistory;

    PlaceHistoryMessage(PlaceHistory placeHistory) {
        this.placeHistory = placeHistory;
    }

    public static PlaceHistoryMessage makePlaceHistoryMessage(PlaceHistory placeHistory) {
        return new PlaceHistoryMessage(placeHistory);
    }

    private static void removeLastSeparator(StringBuffer stringBuffer) {
        stringBuffer.setLength(stringBuffer.length() - 1);
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();

        fillLines(stringBuffer);

        return stringBuffer.toString();

    }

    private void fillLines(StringBuffer stringBuffer) {
        placeHistory.getMatchResults().forEach((matchResult, value) -> appendLine(stringBuffer, matchResult));
        removeLastSeparator(stringBuffer);
    }

    private void appendLine(StringBuffer stringBuffer, MatchResult matchResult) {
        stringBuffer.append(createHistoryLine(matchResult));
    }

    private String createHistoryLine(MatchResult matchResult) {
        return String.format("%s%s%d%s\n", matchResult, COUNT_DIVIDER.getValue(),
                placeHistory.getMatchResults().get(matchResult),
                COUNT_UNIT.getValue());
    }

}
