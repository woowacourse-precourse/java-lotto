package lotto;

import ui.View;

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
    private String numberForm(){
        String message ="[";
        for(int number : numbers){
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 1) + "]";
        return message;
    }

    public void printLotto(){
        View.printLottoNumber(numberForm());
    }

}
