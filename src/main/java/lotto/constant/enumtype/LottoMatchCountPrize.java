package lotto.constant.enumtype;

import java.util.Arrays;
import java.util.List;

public enum LottoMatchCountPrize {
    // 당첨금액, 순위, 순위별 일치 갯수, 보너스번호 매칭 갯수, 당첨 개수
    FIRST_PRIZE(2_000_000_000, Arrays.asList(1, 6, 0, 0)),
    SECOND_PRIZE(30_000_000, Arrays.asList(2, 5, 1, 0)),
    THIRD_PRIZE(1_500_000, Arrays.asList(3, 5, 0, 0)),
    FOURTH_PRIZE(50_000, Arrays.asList(4, 4, 0, 0)),
    FIFTH_PRIZE(5_000, Arrays.asList(5, 3, 0, 0));

    private Integer prize;
    private List<Integer> matchCountInfo;

    LottoMatchCountPrize(Integer prize, List<Integer> matchCountInfo) {
        this.prize = prize;
        this.matchCountInfo = matchCountInfo;
    }

    public String getKey() {
        return name();
    }

    public Integer getPrize() {
        return prize;
    }

    public List<Integer> getMatchCountInfo() {
        return matchCountInfo;
    }
}
