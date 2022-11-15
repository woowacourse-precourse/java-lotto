package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.error_Status;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Range_Exception(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void Range_Exception(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)<1 || numbers.get(i)>45) {
                throw new IllegalArgumentException("[ERROR] 1~45사이의 정수를 입력해주세요.");
            }
        }
    }

    public static List<List<Integer>> result_of_each(List<List<Integer>> issue_numbers, Lotto lotto, int bonus_number){
        List<Integer> issue_number;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<issue_numbers.size(); i++){
            issue_number = issue_numbers.get(i);
            temp.add(compare(issue_number,lotto));
            temp.add(compare_bonus(issue_number, bonus_number));
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }

    public static int compare(List<Integer> issue_number, Lotto lotto){
        int count = 0;
        for(int i=0; i<lotto.numbers.size(); i++){
            if(issue_number.contains(lotto.numbers.get(i))) count++;
        }
        return count;
    }

    public static int compare_bonus(List<Integer> issue_number, int bonus_number){
        if(issue_number.contains(bonus_number)) return 1;
        return 0;
    }
    // TODO: 추가 기능 구현
    public static void Duplicate_exception_bonus(int bonus, Lotto lotto){
        if(lotto.numbers.contains(bonus)) {
            System.out.println("[ERROR] 당첨 번호와 중복되지 않는 값을 입력해주세요.");
            error_Status = true;
//            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 값을 입력해주세요.");
        }
    }

}
