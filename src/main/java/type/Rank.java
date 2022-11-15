package type;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

public enum Rank {
    FIRST("6개 일치 (2,000,000,000원)", 6, number -> number * 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, number -> number * 30000000),
    THIRD("5개 일치 (1,500,000원)", 5, number -> number * 1500000),
    FOURTH("4개 일치 (50,000원)", 4, number -> number * 50000),
    FIFTH("3개 일치 (5,000원)", 3, number -> number * 5000),
    NOTHING("없음", 0, number -> number * 0);

    private String comment;
    private int count;
    private Function<Long, Long> expression;


    Rank(String comment, int count, Function<Long, Long> expression) {
        this.comment = comment;
        this.count = count;
        this.expression = expression;
    }

    public String getComment() {
        return comment;
    }

    public Long calculate(Integer number) {
        return expression.apply(number.longValue());
    }

    public static Rank findRankByCount(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findAny()
                .orElse(Rank.NOTHING);
    }

    public static void printTotalResultComment(Map<Rank, Integer> numbersOfRanks) {
        Arrays.stream(Rank.values()).limit(5).sorted(Comparator.reverseOrder()).forEach(rank ->
                System.out.println(rank.getComment() + " - " + numbersOfRanks.get(rank) + "개"));
    }
}
