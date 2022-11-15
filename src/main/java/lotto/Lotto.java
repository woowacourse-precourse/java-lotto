package lotto;

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

    // TODO: 추가 기능 구현
    /**
     * 당첨 번호를 입력받아 numbers랑 비교하여 일치하는 개수를 return
     */
    public int getCountCorrectNumbers(int[] answerNums) {
        int sameCount = 0;
        for(int i = 0; i < answerNums.length; i++){
            if(numbers.contains(answerNums[i])) sameCount++;
        }
        return sameCount;
    }

    /**
     * 보너스 번호를 입력받아 일치 여부를 return 한다.
     */
    public boolean isSameWithBonumNum(int bonusNum){
        boolean result = false;
        for(int i= 0; i < numbers.size(); i++){
            if(numbers.get(i) == bonusNum){
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * numbers를 출력
     */
    public void printNumbers(){
        System.out.println(numbers);
    }
}
