package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoScoreResult {
    public static final int FIRST_RANK = 1;
    public static final int SECOND_RANK = 2;
    public static final int THIRD_RANK = 3;
    public static final int FOURTH_RANK = 4;
    public static final int FIFTH_RANK = 5;
    public static final int NO_RANK = 0;

    public List<Integer> winScoreList = new ArrayList<>();// 등수별 당첨수 저장

    public LottoScoreResult() {
        winScoreList.add(FIRST_RANK, 0);
        winScoreList.add(SECOND_RANK, 0);
        winScoreList.add(THIRD_RANK, 0);
        winScoreList.add(FOURTH_RANK, 0);
        winScoreList.add(FIFTH_RANK, 0);
        winScoreList.add(NO_RANK, 0);
    }

}
