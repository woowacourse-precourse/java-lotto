package Domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) { //상수
            throw new IllegalArgumentException("로또의 길이가 6이 아닙니다");
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int element : numbers)
            hashSet.add(element);
        if(hashSet.size() != 6) //상수
            throw new IllegalArgumentException("중복된 숫자로 이루어진 로또는 존재 불가능합니다.");
    }

    public List<Integer> getLottoNumbers(){
        return this.numbers;
    }
}
