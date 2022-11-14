package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Grade {
    FIRST("1등", Arrays.asList(6, 0)),
    SECOND("2등", Arrays.asList(5, 1)),
    THIRD("3등", Arrays.asList(5, 0)),
    FOURTH("4등", Arrays.asList(4, 0)),
    FIFTH("5등", Arrays.asList(3, 0)),
    NONE("기타", Collections.EMPTY_LIST);

    private String rank;
    private List<Integer> matching;

    Grade(String rank, List<Integer> matching) {
        this.rank = rank;
        this.matching = matching;
    }

    public static Grade find(List<Integer> comparingResult) {
        return Arrays.stream(Grade.values())
                .filter(matching -> comparingResult.equals(matching))
                .findAny()
                .orElse(NONE);
    }

    public String toString() {
        return name();
    }
}
