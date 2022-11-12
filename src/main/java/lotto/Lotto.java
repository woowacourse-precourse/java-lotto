package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        for(int i= 0; i<numbers.size(); i++){
            if(numbers.get(i) < 1&&numbers.get(i)  >45){
                throw new IllegalArgumentException("[ERROR]");
            }
        }

        HashSet<Integer> temp = new HashSet<Integer>(numbers);

        if(numbers.size() != temp.size())
            throw new IllegalArgumentException("[ERROR]");
    }

    public int compareLotto(Lotto answer, Integer bouns){
        int count = 0;
        for(int i=0; i<this.numbers.size(); i++){
            if(this.numbers.contains(answer.numbers.get(i)))
                count++;
        }

        if(count==5){
            if(this.numbers.contains(bouns))
                count=7;
        }
        return count;
    }

    public void printLotto(){
        System.out.println(numbers);
    }
}
