package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum Win {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    BLANK(0, 0);

    private final int cnt_match;
    private final int prize;

    private Win(int cnt_match, int prize) {
        this.cnt_match = cnt_match;
        this. prize = prize;
    }

    public int getCnt_match() {
        return cnt_match;
    }

    public int getPrize() {
        return prize;
    }

    public static Win ranking(int cnt_match, boolean bonus_number) {
        if(cnt_match == 6){
            return FIRST;
        }
        if(cnt_match ==5 && bonus_number){
            return SECOND;
        }
        if(cnt_match ==5 && !bonus_number){
            return THIRD;
        }
        if(cnt_match ==4) {
            return  FOURTH;
        }
        if(cnt_match ==3){
            return  FIFTH;
        }
        return BLANK;
    }
    public static List<Integer> cnt_total_ranking(List<Integer> match, List<Boolean> match_bonus) {
        List<Win> total_ranking = new ArrayList<>();
        List<Integer> cnt_total_ranking = new ArrayList<>();
        int i = 0;
        while(total_ranking.size() < match.size()) {
            total_ranking.add(ranking(match.get(i), match_bonus.get(i)));
            i++;
        }
        Stream.of(Win.values()).forEachOrdered(r -> cnt_total_ranking.add(Collections.frequency(total_ranking, r)));
        System.out.println("3개 일치 (5,000원) - " + cnt_total_ranking.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + cnt_total_ranking.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + cnt_total_ranking.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +cnt_total_ranking.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + cnt_total_ranking.get(0) + "개");
        return cnt_total_ranking;
    }

    public static void yield(List<Integer> cnt_total_ranking, int money) {
        double revenue = cnt_total_ranking.get(0) * FIRST.prize +
                cnt_total_ranking.get(1) * SECOND.prize +
                cnt_total_ranking.get(2) * THIRD.prize +
                cnt_total_ranking.get(3) * FOURTH.prize +
                cnt_total_ranking.get(4) * FIFTH.prize;

        double yield = (revenue / money) * 100 ;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "% 입니다.");
    }
}
