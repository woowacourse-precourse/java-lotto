package lotto.domain;

import lotto.enums.ResultMessage;
import lotto.enums.ResultStatus;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultStatistics {
    private final List<Result> results;
    private final Map<ResultStatus, Integer> map = new HashMap<>();
    private int totalProfit = 0;

    public ResultStatistics(List<Result> results) {
        this.results = results;
        initMap(map);
        makeMapAndTotalProfit(results);
    }

    private void initMap(Map<ResultStatus, Integer> map) {
        map.put(ResultStatus.MATCH6, 0);
        map.put(ResultStatus.MATCH5_WITH_BONUS_BALL, 0);
        map.put(ResultStatus.MATCH5, 0);
        map.put(ResultStatus.MATCH4, 0);
        map.put(ResultStatus.MATCH3, 0);
        map.put(ResultStatus.NONE2, 0);
        map.put(ResultStatus.NONE1, 0);
        map.put(ResultStatus.NONE0, 0);
    }

    private void makeMapAndTotalProfit(List<Result> results) {
        for (Result result : results) {
            addTotalProfit(result);
            map.put(result.getResultStatus(), map.get(result.getResultStatus()) + 1);
        }
    }

    private void addTotalProfit(Result result) {
        totalProfit += result.getResultStatus().getValue();
    }

    public String printResultStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(MessageFormat.format(ResultMessage.MATCH3.getValue(), map.get(ResultStatus.MATCH3))).append("\n");
        result.append(MessageFormat.format(ResultMessage.MATCH4.getValue(), map.get(ResultStatus.MATCH4))).append("\n");
        result.append(MessageFormat.format(ResultMessage.MATCH5.getValue(), map.get(ResultStatus.MATCH5))).append("\n");
        result.append(MessageFormat.format(ResultMessage.MATCH5_WITH_BONUS_BALL.getValue(), map.get(ResultStatus.MATCH5_WITH_BONUS_BALL))).append("\n");
        result.append(MessageFormat.format(ResultMessage.MATCH6.getValue(), map.get(ResultStatus.MATCH6))).append("\n");
        return result.toString();
    }

    public int getTotalProfit() {
        return totalProfit;
    }
}
