package lotto.domain;

import lotto.resource.ErrorResource;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorResource.errorStart+ErrorResource.numberCountNotFit);
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    // TODO: 추가 기능 구현
    public void validateDuplicate(List<Integer> numbers){
        for(int i=0;i<numbers.size();i++){
            checkDuplicate(numbers, i);
        }
    }

    private void checkDuplicate(List<Integer> numbers, int i) {
        for(int j = 0; j< numbers.size(); j++){
            if(i !=j && (numbers.get(i).equals(numbers.get(j)))) {
                throw new IllegalArgumentException(ErrorResource.errorStart+ErrorResource.numberDuplicate);
            }
        }
    }


}
