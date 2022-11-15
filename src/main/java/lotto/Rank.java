package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5.5f, 30_000_000),
    ALL_MATCH(6, 2_000_000_000);

    private final float matching;
    private final long prize;

    Rank(float matching, long prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public float getMatching() {
        return this.matching;
    }

    public long getPrize() {
        return this.prize;
    }

    /**
     * 어떤 것을 수정해야할까?
     *
     * getMatching 이 아닌, 그냥 matching 번호를 넘겨주면?
     * 그리고 values 를 했을 때 그것을 List 로 넘겨주어도 되겠다.
     */


    public static List<Float> getNumbersOfMatching() {
        List<Float> numbersOfMatching = new ArrayList<>();

        Arrays.stream(values())
                .forEach(rank -> numbersOfMatching.add(rank.matching));

        return numbersOfMatching;
    }
}
