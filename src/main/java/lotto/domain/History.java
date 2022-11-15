package lotto.domain;


import java.util.List;
import lotto.controller.HistoryBuilder;

// 로또 추첨 기록 보관하기
public class History extends HistoryBuilder {

    List<String> historyList;

    public History() {
        this.historyList = addHistory();
    }

    // 당첨 내역 및 수익률을 돌려준다.
    private List<String> addHistory() {

        historyList.add(buildMatchHistory());
        historyList.add(buildYieldHistory());

        return historyList;
    }

    public String getMatchResult() {

        return new History().historyList.get(0);
    }

    public String getYieldResult() {
        return new History().historyList.get(1);
    }

}
