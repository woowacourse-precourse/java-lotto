package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private int minNum = 1;
    private int maxNum = 45;
    private int numSize = 6;

    public LottoMachine(int minNum, int maxNum, int numSize){
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.numSize = numSize;

    }

    // 중복되지 않는 6개의 숫자를 뽑기
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < numSize) {
            int randomNumber = Randoms.pickNumberInRange(minNum, maxNum);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;

    }

}
