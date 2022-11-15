package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSame(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public int get(int index){
        return numbers.get(index);
    }

    private void checkSame(List<Integer> numbers){
        for(int index1=0;index1<numbers.size()-1;index1++){
            for(int index2=index1+1;index2<numbers.size();index2++){
                checkSameNumber(numbers.get(index1),numbers.get(index2));
            }
        }
    }

    private void checkSameNumber(int number1, int number2){
        if(number1==number2){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        String printString="[";
        for(int index=0;index<numbers.size();index++){
            printString+=numbers.get(index);
            if(index==numbers.size()-1){
                printString+="]";
            }
            if(index!=numbers.size()-1) {
                printString += ", ";
            }
        }
        return printString;
    }
}
