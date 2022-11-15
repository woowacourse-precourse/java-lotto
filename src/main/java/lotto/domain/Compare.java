package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class Compare {
    private static final Rank[] RANKS = {FIFTH, FOURTH, THIRD, SECOND, FIRST};
    private static int first;
    private static int second;
    private static int third;
    private static int fourth;
    private static int fifth;
    public int compareNumbers(List<Integer> lottoGroups, List<Integer> lottoNum) {
        int cnt = 0;
        for (int i = 0; i < lottoNum.size(); i++) {
            if (lottoGroups.contains(lottoNum.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }
    public Rank compare_Numbers_Group(Map<Integer, List> lottoGroups, List<Integer> lottoNum, int bonusNum) {

        for (int i = 0; i < lottoGroups.size(); i++) {
            int cnt = compareNumbers(lottoGroups.get(i), lottoNum);
            if (cnt == 6) {
                first++;
                return FIRST;
            }
            if (cnt == 5 && lottoGroups.get(i).contains(bonusNum)) {
                second++;
                return SECOND;
            }
            if (cnt == 5) {
                third++;
                return THIRD;
            }
            if (cnt == 4) {
                fourth++;
                return FOURTH;
            }
            if (cnt == 3) {
                fifth++;
                return FIFTH;
            }
        }
        return NOTHING;
    }
    public static List<Integer> rankList() {
        List<Integer> rankcnt = new ArrayList<>();
        rankcnt.add(fifth);
        rankcnt.add(fourth);
        rankcnt.add(third);
        rankcnt.add(second);
        rankcnt.add(first);
        return rankcnt;
    }


    public static void printRank() {
        rankList();
        for (int i=0; i<RANKS.length; i++) {
            Rank rank = Rank.getLottoRanksDesc().get(i);
            rank.printRank(rankList().get(i));
        }
    }


}
