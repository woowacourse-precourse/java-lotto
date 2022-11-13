package lotto;


import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        List<String> winnings = List.of(numbers.split(","));
        List<Integer> win = new ArrayList<>();

        for(int i=0; i<winnings.size(); i++){
            win.add(Integer.parseInt(winnings.get(i)));
        }
        validate(win);
        this.numbers = win;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
