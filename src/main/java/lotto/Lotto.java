package lotto;

import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer minLottoNum = 1;
    private final Integer maxLottoNum = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LIST_SIZE.getDesc());
        }
        if(numbers.size()!= Sets.newHashSet(numbers).size()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LIST_DUPLICATE.getDesc());
        }
        if(numbers.stream().filter((num) -> num > maxLottoNum || num <minLottoNum).count()>0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INT_RANGE.getDesc());
        }
    }
    public void printNumbers(){
        System.out.println(numbers);
    }
    public int compare(Lotto lotto){
        int correctNum = 0;
        for(int i=0;i<6;i++) {
            if(numbers.contains(lotto.numbers.get(i))){
                correctNum+=1;
            }
        }
        return correctNum;
    }
    public boolean containBonus(int bonus){
        if(numbers.contains(bonus)){
            return true;
        }
        return false;
    }
    // TODO: 추가 기능 구현
}
