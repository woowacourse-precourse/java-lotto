package lotto;

import java.util.*;

public class Lotto {
    private final int LOTTO_NUMBER = 6;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;
    private final List<Integer> numbers;

    private String rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // 에러 원인 : pickUniqueNumbersInRange()메서드의 final List<Integer> numbers = new ArrayList<>(); 바꿀수 없음!!
    private void sort(List<Integer> numbers) {
//        numbers.sort(Integer::compare);
        Collections.sort(numbers);
    }

    private boolean isCorrectSize(List<Integer> numbers) {

        return numbers.size() == LOTTO_NUMBER;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LOTTO_NUMBER;
//        return Set.of(numbers).size() == LOTTO_NUMBER;        ?????copyof랑 다른점?>???
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }

    private boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }
    // TODO: 추가 기능 구현

    public int calculateMatchCount(List<Integer> winningLotto) {
        int matchCount = 0;
        for(Integer lottoNumber : numbers){
            if(winningLotto.contains(lottoNumber)){
                matchCount++;
            }
        }
        return matchCount;
    }

    //로또 등수 정하기
    public Map<Integer,String> rankMap = Map.of(
        6, "FIRST",
        5,"THIRD",
        4,"FOURTH",
        3,"FIFTH"
    );
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
}
