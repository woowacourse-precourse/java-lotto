package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Win {
    NONE(0, -1, true),
    FIFTH(5_000, 3, true),
    FIFTH_WITHOUT_BONUS(5_000, 3, false),
    FOURTH(50_000, 4, true),
    FOURTH_WITHOUT_BONUS(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, true),
    FIRST_WITHOUT_BONUS(2_000_000_000, 6, false);

    private final Integer PRIZE;
    private final Integer MATCH;
    private final boolean BONUS;
    private Integer count = 0;

    Win(Integer PRIZE, Integer MATCH, boolean BONUS) {
        this.PRIZE = PRIZE;
        this.MATCH = MATCH;
        this.BONUS = BONUS;
    }

    private void setCount(Integer count) {
        this.count = count;
    }

    public static void initializeCount(){
        Arrays.stream(Win.values())
                .forEach(win -> win.setCount(0));
    }

    private static Win getWin(int matchCount, boolean bonus){
        return Arrays.stream(Win.values())
                .filter(win -> win.MATCH == matchCount && win.BONUS == bonus)
                .findAny()
                .orElse(NONE);
    }

    public static Integer getPRIZE(int matchCount, boolean bonus) {
        return getWin(matchCount, bonus).PRIZE;
    }

    public static void increaseCount(int matchCount, boolean bonus) {
        getWin(matchCount, bonus).count++;
    }

    /*
    반환 되는 배열의 인덱스 - 등수
                    값 - 횟수
     */
    public static List<Integer> getCountTable() {
        List<Integer> countTable = new ArrayList<>();

        writeTable(countTable);

        return countTable;
    }

    private static void writeTable(List<Integer> table) {
        table.add(0);                                                  // 0등 - 더미데이터
        table.add(Win.FIRST.count + Win.FIRST_WITHOUT_BONUS.count);    // 1등
        table.add(Win.SECOND.count);                                   // 2등
        table.add(Win.THIRD.count);                                    // 3등
        table.add(Win.FOURTH.count + Win.FOURTH_WITHOUT_BONUS.count);  // 4등
        table.add(Win.FIFTH.count + Win.FIFTH_WITHOUT_BONUS.count);    // 5등
    }
}
