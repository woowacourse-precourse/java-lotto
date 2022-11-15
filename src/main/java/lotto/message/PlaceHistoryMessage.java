package lotto.message;

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
    /*
     * 1. 이것 팩토리 함수 만들기
     * 2. 이이상한거 테스트 삭제하기
     * 3. rate 관련 메시지 객체를 따로 만들기
     * */

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

    private void appendLine(StringBuffer stringBuffer,
                            MatchResult matchResult) {
        stringBuffer.append(createHistoryLine(matchResult));
    }

    private String createHistoryLine(MatchResult matchResult) {
        return String.format("%s - %d개\n", matchResult, placeHistory.getMatchResults().get(matchResult));
    }

}
