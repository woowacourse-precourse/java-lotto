package lotto;



import java.util.List;

public class Lotto {



    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개이어야 한다.");
        }
        for (int i : numbers){
            if(numbers.indexOf(i) != numbers.lastIndexOf(i)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 안된다.");
            }
        }
    }



    public List<Integer> getNumbers() {
        return numbers;
    }






}
