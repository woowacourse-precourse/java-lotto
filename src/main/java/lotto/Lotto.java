package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String[] numbers) {
        try {
            ArrayList<Integer> changeNumbers = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                changeNumbers.add(Integer.parseInt(numbers[i]));
            }
            validate(changeNumbers);
            this.numbers = changeNumbers;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> deleteSameThing = new HashSet<>(numbers);
        numbers = new ArrayList<>(deleteSameThing);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (!(number >= 1 && number <= 45))
                throw new IllegalArgumentException();
        }
    }

    public String getLottoText() {
        Integer[] numberList = numbers.toArray(new Integer[numbers.size()]);
        Arrays.sort(numberList);
        return Arrays.toString(numberList);
    }

    public ArrayList<Integer> getLotto(){
        ArrayList<Integer> lottos=new ArrayList<>(numbers);
        Collections.sort(lottos);
        return lottos;
    }
    // TODO: 추가 기능 구현
}
