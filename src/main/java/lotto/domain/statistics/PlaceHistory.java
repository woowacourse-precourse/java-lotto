package lotto.domain.statistics;

import static lotto.domain.place.MatchResult.FIFTH_PLACE;
import static lotto.domain.place.MatchResult.FIRST_PLACE;
import static lotto.domain.place.MatchResult.FOURTH_PLACE;
import static lotto.domain.place.MatchResult.SECOND_PLACE;
import static lotto.domain.place.MatchResult.THIRD_PLACE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.place.MatchResult;

public class PlaceHistory {

    public static final int ONCE = 1;
    public static final int INIT_VALUE = 0;
    Map<MatchResult, Integer> matchResults;

    public PlaceHistory() {
        fillMatchResults();
    }

    public void updateFor(MatchResult matchResult) {
        if (!matchResults.containsKey(matchResult)) {
            return;
        }

        addCountFor(matchResult);
    }

    public long amountSum() {
        return matchResults.entrySet().stream().mapToLong(this::amountFor).sum();

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        fillLines(stringBuffer);

        return stringBuffer.toString();
    }

    private void fillMatchResults() {
        matchResults = new LinkedHashMap<>();

        matchResults.put(FIFTH_PLACE, INIT_VALUE);
        matchResults.put(FOURTH_PLACE, INIT_VALUE);
        matchResults.put(THIRD_PLACE, INIT_VALUE);
        matchResults.put(SECOND_PLACE, INIT_VALUE);
        matchResults.put(FIRST_PLACE, INIT_VALUE);
    }

    private void addCountFor(MatchResult matchResult) {
        matchResults.merge(matchResult, ONCE, Integer::sum);
    }

    private long amountFor(Entry<MatchResult, Integer> entity) {
        return entity.getKey().getAmount(entity.getValue());
    }

    private void fillLines(StringBuffer stringBuffer) {
        matchResults.forEach((matchResult, value) -> appendLine(stringBuffer, matchResult));
    }

    private void appendLine(StringBuffer stringBuffer, MatchResult matchResult) {
        stringBuffer.append(createHistoryLine(matchResult));
    }

    private String createHistoryLine(MatchResult matchResult) {
        return String.format("%s - %d개\n", matchResult, matchResults.get(matchResult));
    }
}
