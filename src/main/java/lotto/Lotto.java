package lotto;

import java.util.ArrayList;
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 하며 중복은 불가합니다.");
        }
    }

    public void display_num(){
        List<Integer> sorted_numbers = new ArrayList<>();
        sorted_numbers.addAll(numbers);
        Collections.sort(sorted_numbers);
        System.out.println(Arrays.deepToString(sorted_numbers.toArray()));
    }
    
    public int compare_win(Lotto win, int bonus){
        int count = 0;

        for (int i = 0; i < numbers.size(); i++){
            if (win.get_numbers().contains(numbers.get(i))){
                count++;
            }
        }

        // 6개 번호를 모두 맞은 경우가 제일 좋은 경우이므로 count를 7로 올린다.
        if (count == 6){
            count++;
        }

        // 5개 번호를 맞추고 보너스 번호를 맞은 경우가 두 번째로 좋은 경우이므로 count를 6으로 올린다.
        // 즉, count가 3,4,5,6,7일 때가 각각 3개 일치, 4개 일치, 5개 일치, 5개 일치+보너스 볼 일치, 6개 일치로 대응된다.
        if (count == 5){
            if (win.get_numbers().contains(bonus)){
                count++;
            }
        }
        return count;
    }
}
