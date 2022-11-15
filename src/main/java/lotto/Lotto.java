package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if( numbers.size() != 6 ) throw new IllegalArgumentException("[ERROR] 숫자의 개수를 6개민 유효합니다.");
        for(Integer number : numbers){
            if(number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위는 1에서 45사이만 유효합니다.");
            if(number == null) throw new IllegalArgumentException("[ERROR] 로또 숫자는 널이 될 수 없습니다.");
            if(numbers.indexOf(number) != numbers.lastIndexOf(number)){
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복될 수 없습니다.");
            }
        }
    }
}
