package lotto.app;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {
    public void hasSixItems(List<Integer> numbers){
        if(numbers.size() != 6){
            System.out.println("[ERROR] 로또 번호는 총 6개여야 합니다.");
            throw new IllegalArgumentException();
        }

    }

    public void isInRange(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            if( 1 > numbers.get(i) || numbers.get(i) > 45){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }

    }

    public void isNotDuplicate(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            List<Integer> number = numbers.stream()
                    .filter(numbers.get(i)::equals)
                    .collect(Collectors.toList());
            if(number.size() != 1){
                System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void isThousandUnit(int money){
        if(money % 1000 != 0){
            System.out.println("[ERROR] 로또 구입 금액은 1000 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
