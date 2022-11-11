package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumberASC();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 자동 생성 번호는 6개 숫자로 구성되어야 합니다.");
        }
    }

    // 로또 번호 오름차순 정렬
    private void sortNumberASC(){
        Collections.sort(numbers);
    }

    // 로또 번호 출력
    public void printLottoNumbers(){
        System.out.print("[");
        for(int i=0; i<numbers.size(); i++){
            System.out.print(numbers.get(i));
            if(i!=numbers.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
