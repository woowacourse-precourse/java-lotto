package lotto;

import ui.View;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers){
        validateNull(numbers);
        validateDuplicate(numbers);
        validateLength(numbers);
        validateOutRange(numbers);
    }
    private void validateNull(List<Integer> numbers){
        if(numbers.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateOutRange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException();
            }
        }
    }
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != 6){
            throw new IllegalArgumentException();
        }
    }
    public String toNumberForm(){
        String message ="[";
        for(int number : numbers){
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 2) + "]";
        return message;
    }

    public void printLotto(){
        View.printLottoNumber(toNumberForm());
    }

}
