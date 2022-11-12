package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {
    private final int LOTTO_NUMBER = 6;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;
    private final List<Integer> numbers;

    private String rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public int calculateMatchCount(List<Integer> winningLotto) {
        int matchCount = 0;
        for(Integer lottoNumber : numbers){
            if(winningLotto.contains(numbers)){
                matchCount++;
            }
        }
        return matchCount;
    }

    //로또 등수 정하기
    public void setRank(List<Integer> winningLotto, int bonusNumber){
        int matchCount = calculateMatchCount(winningLotto);
        if(matchCount ==5 && numbers.contains(bonusNumber)){
            rank = "SECOND";
            return;
        }
        rank = rankMap.getOrDefault(matchCount,"");
    }

    public String getRank() {
        return rank;
    }

    public Map<Integer,String> rankMap = Map.of(
        6, "FIRST",
        5,"THIRD",
        4,"FOURTH",
        3,"FIFTH"
    );

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compare);
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return Set.of(numbers).size() == LOTTO_NUMBER;
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }

    private boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }
    // TODO: 추가 기능 구현
}
