package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MatchCount {
    THIRD("3개 일치 (5,000원) - ", 0, 5000),
    FOURTH("4개 일치 (50,000원) - ", 1, 50000),
    FIFTH("5개 일치 (1,500,000원) - ", 2, 1500000),
    FIFTH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3, 30000000),
    ALL_MATCH("6개 일치 (2,000,000,000원) - ", 4, 2000000000);

    private final String label;
    private final int number;
    private final int proceeds;

    MatchCount(String label, int number, int proceeds) {
        this.label = label;
        this.number = number;
        this.proceeds = proceeds;
    }

    public String label(){
        return label;
    }

    public int number(){
        return number;
    }

    public int proceeds(){
        return proceeds;
    }

    private static final Map<String, MatchCount> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(MatchCount::label, Function.identity()));

    private static final Map<Integer, MatchCount> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(MatchCount::number, Function.identity()));

    private static final Map<Integer, MatchCount> BY_PROCEEDS =
            Stream.of(values()).collect(Collectors.toMap(MatchCount::proceeds, Function.identity()));

    public static MatchCount valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static MatchCount valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }
}
