package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get_numbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 하며 중복은 불가합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void display_num(){
        Collections.sort(numbers);
        System.out.println(Arrays.deepToString(numbers.toArray()));
    }
    
    public int compare_win(Lotto win, int bonus){
        int count = 0;

        for (int i = 0; i < numbers.size(); i++){
            if (win.get_numbers().contains(numbers.get(i))){
                count++;
            }
        }

        if (count == 6){
            count++;
        }

        if (count == 5){
            if (win.get_numbers().contains(bonus)){
                count++;
            }
        }
        return count;
    }
}
