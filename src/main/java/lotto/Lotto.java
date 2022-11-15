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

    // TODO: 추가 기능 구현

    public List<Integer> getLottoNum()
    {
        return this.numbers;
    }

    public void printNumber()
    {
        System.out.println(this.numbers.toString());
    }

    public boolean isContaining(int number)
    {
        return numbers.contains(number);
    }
    
    public int getSameNum(WinnersLotto winnersLotto)
    {
        return (int) numbers.stream().filter(winnersLotto::isContaining).count();
    }
}
