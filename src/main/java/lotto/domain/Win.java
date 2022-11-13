package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Win {
    NONE(0, -1, true, -1),
    FIFTH(5_000, 3, true, 5),
    FIFTH_WITHOUT_BONUS(5_000, 3, false, 5),
    FOURTH(50_000, 4, true, 4),
    FOURTH_WITHOUT_BONUS(50_000, 4, false, 4),
    THIRD(1_500_000, 5, false, 3),
    SECOND(30_000_000, 5, true, 2),
    FIRST(2_000_000_000, 6, true, 1),
    FIRST_WITHOUT_BONUS(2_000_000_000, 6, false, 1);

    private final Integer PRIZE;
    private final Integer MATCH;
    private final boolean BONUS;
    private final Integer RANK;
    private Integer count = 0;

    Win(Integer PRIZE, Integer MATCH, boolean BONUS, Integer RANK) {
        this.PRIZE = PRIZE;
        this.MATCH = MATCH;
        this.BONUS = BONUS;
        this.RANK = RANK;
    }

    private void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRANK() {
        return RANK;
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

    private static void writeTable(List<Integer> winHistory) {
        List<Win> history = Arrays.stream(Win.values()).collect(Collectors.toList());
        winHistory.add(0);                                              // 0등 - 더미데이터
        winHistory.add(history.get(8).count + history.get(7).count);    // 1등
        winHistory.add(history.get(6).count);                           // 2등
        winHistory.add(history.get(5).count);                           // 3등
        winHistory.add(history.get(4).count + history.get(3).count);    // 4등
        winHistory.add(history.get(2).count + history.get(1).count);    // 5등
    }
}
