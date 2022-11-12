package lotto.domain;

import java.util.Arrays;
import lotto.NumberFormatter;

public enum Rank {
    NOTHING(0,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000);

    private Integer matchBallCnt;
    private Integer money;

    Rank(Integer matchBallCnt, Integer money) {
        this.matchBallCnt = matchBallCnt;
        this.money = money;
    }

    public static Rank valueOf(Integer matchBallCnt, boolean hasBonusNumber) {
        if(matchBallCnt == 5) {
             if (hasBonusNumber) {
                 return Rank.SECOND;
             }
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchBallCnt() == matchBallCnt)
                .findAny()
                .orElse(NOTHING);
    }

    private Integer getMatchBallCnt() {
        return matchBallCnt;
    }

    public Integer getMoney() {
        return money;
    }

    @Override
    public String toString() {
        String str = matchBallCnt + "개 일치";
        if(this == Rank.SECOND) {
            str += ", 보너스 볼 일치";
        }
        return str + " (" + NumberFormatter.format(money) + "원)";
    }

    // 의문 : toString이나 valueOf에 로직이 들어가도 괜찮겠지?
    // 느낌으로는 괜찮음 -> 다른곳에서 일어나는거도 아니고 객체 내에서 작업이 일어나니까. 그러도 확신 안드니까 다른 분들의 풀이 살펴보기
}
