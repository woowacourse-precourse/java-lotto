package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

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
    
    public int compare_win(Lotto win){
        int count = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (win.get_numbers().contains(numbers.get(i))){
                count++;
            }
        }
        return count;
    }
}
