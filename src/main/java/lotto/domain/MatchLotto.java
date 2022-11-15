package lotto.domain;

import java.util.List;

public class MatchLotto {

    private static int rank1 = 0;
    private static int rank2 = 0;
    private static int rank3 = 0;
    private static int rank4 = 0;
    private static int rank5 = 0;
    private static double revenue = 0;

    public int getRankDetail(int count, boolean matchBonus) {
        if (count == 6) {
            return 1;
        }
        if (count == 5) {
            if (matchBonus) {
                return 2;
            }
            return 3;
        }
        if (count == 4) {
            return 4;
        }
        return 5;
    }

}
