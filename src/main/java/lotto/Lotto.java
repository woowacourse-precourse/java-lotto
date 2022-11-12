package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Lotto {
    private final int LOTTERY_NUMBER_LIMIT = 6;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_LIMIT) {
            System.out.println("[ERROR] 당첨 번호는 정확히 6개를 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
        Iterator itrForNumbers = numbers.iterator();
        int[] arrayForCheckOverLap = new int[46];
        while (itrForNumbers.hasNext()){
            int checkIndex = (int)itrForNumbers.next();
            if (arrayForCheckOverLap[checkIndex] == 1){
                System.out.println("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
                throw new IllegalArgumentException();
            }
            arrayForCheckOverLap[checkIndex] = 1;
        }
    }
    public void checkLottoWinnings(ArrayList<int[]> lotteryBundleArray, int bonusWinningNumber) {

    }
}
