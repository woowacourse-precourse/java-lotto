package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public int check(List<Integer> temp,int bonus){
        int count=0;
        for(int i=0;i<numbers.size();i++){
                if(numbers.contains(temp.get(i))){
                    count++;
                }

        }
        if(count==5&&temp.contains(bonus))count=-1;
        return count;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() > 6 || numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]6자리 미만이거나 중복하는 값이 존재합니다.");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
