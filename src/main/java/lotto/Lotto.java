package lotto;

import java.util.ArrayList;
import java.util.Collections;
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
    public void printLotto(){
        List<Integer> sortedLotto = new ArrayList<>(this.numbers);
        Collections.sort(sortedLotto);
        System.out.println(sortedLotto);
    }

    public int compareWithWinningNumbers(List<Integer> winningNumbers){
        int bonusNumber = winningNumbers.get(6);
        int sameNumCount = getSameNumCount(winningNumbers);
        if (sameNumCount == 5 && hasBonusNumber(bonusNumber)) {
            return 1;
        }
        if (sameNumCount <= 5) { // 2등과 3등 둘다 sameNumCount 가 5이기 때문에 3등부터 1씩 뺌
            sameNumCount--;
        }
        return whichPlace(sameNumCount);
    }

    private int getSameNumCount(List<Integer> winningNumbers) {
        List<Integer> withoutBonusNumber = winningNumbers.subList(0,6);
        int sameNumCount = 0;
        for (Integer num :this.numbers){
            if (withoutBonusNumber.contains(num)){
                sameNumCount++;
            }
        }
        return sameNumCount;
    }

    private int whichPlace(int sameNumCount){ // 같은 번호가 얼마나 맞았는지를 통해 몇 등인지 계산
        int place = Math.abs(sameNumCount - 6);
        if (place > 4) { // 5등 이하, 즉 같은 번호가 3개도 안되는 경우들
            return 5;
        }
        return place;
    }

    public boolean hasBonusNumber(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }

}
