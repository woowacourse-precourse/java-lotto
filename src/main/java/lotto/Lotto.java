package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.numberCountValidation(numbers);
        Validation.numberRangeValidation(numbers);
        Validation.numberDuplicateValidation(numbers);
    }
    public Long sameNumber(Lotto lotto,Integer bonus){
        Long score = numbers.stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count() * 10;
        if(score == 50 && numbers.contains(bonus)) score += 1;
        return score;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("[");
        for(int i = 0;i < numbers.size();i++) {
            result.append(numbers.get(i));
            if(i <= numbers.size() - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }


}
