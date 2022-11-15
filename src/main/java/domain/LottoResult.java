package domain;

import java.util.List;

public class LottoResult {
    private final List<Integer> lottoStatistics;
    private final int money;

    public LottoResult(List<Integer> lottoStatistics, int money) {
        this.lottoStatistics = lottoStatistics;
        this.money = money;
    }
}
