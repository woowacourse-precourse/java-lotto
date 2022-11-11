package lotto.constant;

import java.util.function.Function;

public enum MatchType {

    THREE_MATCHES(count -> "3개 일치 (%,d원) - " + count + "개\n"),
    FOUR_MATCHES(count -> "4개 일치 (%,d원) - " + count + "개\n"),
    FIVE_MATCHES_WITHOUT_BONUS(count -> "5개 일치 (%,d원) - " + count + "개\n"),
    FIVE_MATCHES_WITH_BONUS(count -> "5개 일치, 보너스 볼 일치 (%,d원) - " + count + "개\n"),
    SIX_MATCHES(count -> "6개 일치 (%,d원) - " + count + "개\n");

    private final Function<Integer, String> template;

    MatchType(Function<Integer, String> template) {
        this.template = template;
    }

    public String printMessage(Integer input) {
        return this.template.apply(input);
    }
}
