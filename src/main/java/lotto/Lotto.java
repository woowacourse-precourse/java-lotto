package lotto;

import java.util.Comparator;
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
        numbers.sort(Comparator.naturalOrder());
    }

    public void printNumbers(){
        System.out.println(numbers);
    }

    public boolean isContainBounus(Integer bouns){
        if(this.numbers.contains(bouns)) return true;
        else return false;
    }

    public Integer getNumberOfMatch(List<Integer> num, Integer bounus){
        int count=0;
        for(Integer a : num){
            if(this.numbers.contains(a)) count++;
        }
    return count;
    }
}
