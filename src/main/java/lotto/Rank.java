package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
//    - 1등: 6개 번호 일치 / 2,000,000,000원
//    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//    - 3등: 5개 번호 일치 / 1,500,000원
//    - 4등: 4개 번호 일치 / 50,000원
//    - 5등: 3개 번호 일치 / 5,000원
    FIRST(6,"2,000,000,000원",0),
    SECOND(5,"30,000,000원",1),
    THIRD(5,"1,500,000원", 0),
    FOURTH(4,"50,000원",0),
    FIFTH(3,"5,000원",0);
    private final int count;
    private final String money;
    private final int bonus;
    Rank(int count, String money, int bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
    }
//    public List<Rank> getStringResult(List<Integer> resultList) {
//        List<Rank> rankList = new ArrayList<Rank>();
//        for (int result: resultList ){
//            Rank rank = findRank(result);
//            rankList.add(rank);
//        }
//        return rankList
//    }

//    public Rank findRank(int result){
//        if (result == 5 ) {
//            if
//        }
//        for (Rank value: values() ) {
//            if (value.count == result) {
//                return value;
//            }
//        }
//    }

}
