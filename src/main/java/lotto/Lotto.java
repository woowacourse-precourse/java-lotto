package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // <Func> Get lotto and return guessed num in normal numbers
    public int getNormalSameNum(List<Integer> lotto) {
        int normalCnt = 0;

        for (int i = 0; i < 6; i++) {
            // if number in ans
            if (numbers.contains(lotto.get(i)) == true) {
                normalCnt += 1;
            }
        }

        return normalCnt;
    }

    // <Func> Get boolean value if player get bonus number right
    public boolean isBonusGetRight(List<Integer> lotto, int bonus) {
        return lotto.contains(bonus);
    }

    public Rank distinguishSecondAndThird(boolean matchBonus) {
        if (matchBonus == true) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public Rank getRank(int matchNormal, boolean matchBonus) {
        // TODO: Find rank by match normal number and match bonus number
        if (matchNormal == 5) {
            return distinguishSecondAndThird(matchBonus);
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatch() == matchNormal) {
                return rank;
            }
        }

        return Rank.NONE;
    }

    // <Func> Get List of lotto and make list of rank for statistics
    public List<Rank> getRankList(List<List<Integer>> lottoList, int bonus) {
        List<Rank> rankList = new ArrayList<>();
        Rank rank;
        int normalCount;
        boolean bonusCorrect;

        for (int i = 0; i < lottoList.size(); i++) {
            normalCount = getNormalSameNum(lottoList.get(i));
            bonusCorrect = isBonusGetRight(lottoList.get(i), bonus);

            rankList.add(getRank(normalCount, bonusCorrect));
        }

        return rankList;
    }
}
