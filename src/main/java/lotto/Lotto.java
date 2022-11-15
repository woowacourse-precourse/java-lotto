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
            throw new IllegalArgumentException();
        }
    }


    public void printNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> lottoGroupadd(List<Lotto> lottos) {
        List<Integer> lottoNumbers = numbers;
        return lottoNumbers;
    }
    // TODO: 추가 기능 구현
}
