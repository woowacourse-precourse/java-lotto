package domain;

import java.util.*;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public int countMatch(List<Integer> winningNum) {
        return (int) numbers.stream().filter(winningNum::contains).count();
    }


    public boolean matchBonus(int bonusNum) {
        if ( numbers.contains(bonusNum)) return true;
        return false;
    }

    public void getRank(List<Integer> matchNum, int matchBonus) {
        if (countMatch(matchNum) == 4) LottoRank.MATCH_FOUR.countRank();
        if (countMatch(matchNum) == 5) {
            if (matchBonus(matchBonus)) {
                LottoRank.MATCH_FIVE_AND_BONUS.countRank();
            }
            LottoRank.MATCH_FIVE.countRank();
        }
        if (countMatch(matchNum) == 6) LottoRank.MATCH_SIX.countRank();
        if (countMatch(matchNum) == 3) LottoRank.MATCH_THREE.countRank();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
