package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Result {
    FIRST(List.of("60"), 200_000_000),
    SECOND(List.of("51"), 30_000_000),
    THIRD(List.of("50"), 1_500_000),
    FOURTH(List.of("40", "41"), 50_000),
    FIFTH(List.of("30", "31"), 5_000),
    LOSE(Collections.EMPTY_LIST, 0);

    // 당첨 번호와 일치 개수, 보너스 번호 일치 개수의 조합
    private List<String> resultCode;
    private int prizeMoney;

    Result(List<String> resultCode, int prizeMoney) {
        this.resultCode = resultCode;
        this.prizeMoney = prizeMoney;
    }

    public static Result findByResultCode(String resultCode) {
        return Arrays.stream(Result.values())
                .filter(result -> result.hasResultCode(resultCode))
                .findAny()
                .orElse(LOSE);
    }

    public boolean hasResultCode(String resultCode) {
        return this.resultCode.stream()
                .anyMatch(code -> code.equals(resultCode));
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
