package lotto;

import java.text.DecimalFormat;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    public int getCount(int money) {
        int count = 0;
        count = money / 1000;
        return count;
    }

    public List<Integer>[] issueLotto(int count) {
        List<Integer>[] issuedList = new List[count];
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            issuedList[i] = numbers;
        }
        return issuedList;
    }

    public Lotto issueWinningNumber(List<Integer> numbers) {
        Lotto winningLotto = new Lotto(numbers);
        return winningLotto;
    }

    public HashMap<Rank,Integer> getRankMap(List<Integer>[] resultList){
        HashMap<Rank,Integer> rankMap = new HashMap<>(6);
        for (List<Integer> result: resultList) {
            int count = result.get(0);
            int bonus = result.get(1);
            Rank rank = getRank(count, bonus);
            if (rankMap.get(rank)==null) {
                rankMap.put(rank,1);
                continue;
            }
            rankMap.put(rank, rankMap.get(rank)+1);
        }
        return rankMap;
    }

    public Rank getRank(int count, int bonus) {
        if (count==6){
            return Rank.FIRST;
        }
        if (count==5 && bonus==1){
            return Rank.SECOND;
        }
        if (count==5 && bonus==0) {
            return Rank.THIRD;
        }
        if (count==4) {
            return Rank.FOURTH;
        }
        if (count==3) {
            return Rank.FIFTH;
        }
        return Rank.NOTHING;
    }

    public double getYield(int money, HashMap<Rank,Integer> rankMap) {
        if (rankMap.size() ==0 ){
            return 0.0;
        }
        double earnings = 0;
        for (Rank rank: rankMap.keySet()) {
            earnings += rankMap.get(rank) * rank.getMoney();
        }

//        return String.format("%.1f",(double) earnings/(double) money * 100 );
        return Math.round(earnings/money * 1000) / 10.0;
    }
}
