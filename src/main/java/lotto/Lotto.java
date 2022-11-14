package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers); // 오름차순 정렬
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void printLotto(){
        System.out.println(this.numbers);
    }

    public int compareWithWinningNumbers(List<Integer> winningNumbers){
        List<Integer> withoutBonusNumber = winningNumbers.subList(0,6);
        int sameNumCount = 0;
        for (Integer num :this.numbers){
            if (withoutBonusNumber.contains(num)){
                sameNumCount++;
            }
        }
        return whichPlace(sameNumCount);
    }

    private int whichPlace(int sameNumCount){ // 같은 번호가 얼마나 맞았는지를 통해 몇 등인지 계산
        int place = Math.abs(sameNumCount - 6);
        if (place > 3) { // 5등 이하, 즉 같은 번호가 3개도 안되는 경우들
            return 4;
        }
        return place;
    }

}
