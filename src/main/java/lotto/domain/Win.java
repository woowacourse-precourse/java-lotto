package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Win {
    NON(0), ONE(0), TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000),
    FIVE_BONUS(30_000_000);

    private final Integer PRIZE;
    private Integer count = 0;

    Win(Integer PRIZE) {
        this.PRIZE = PRIZE;
    }

    private void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public static void initializeCount(){
        Arrays.stream(Win.values())
                .forEach(win -> win.setCount(0));
    }

    private static Win getWin(int matchCount, boolean bonus){
        return Arrays.stream(Win.values())
                .filter(win -> !(matchCount == 5 && bonus) && win.ordinal() == matchCount)
                .findAny()
                .orElse(FIVE_BONUS);
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
        winHistory.add(0);                      // 0등 - 더미데이터
        winHistory.add(history.get(6).count);   // 1등
        winHistory.add(history.get(7).count);   // 2등
        winHistory.add(history.get(5).count);   // 3등
        winHistory.add(history.get(4).count);   // 4등
        winHistory.add(history.get(3).count);   // 5등
    }
}
