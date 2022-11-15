package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> nums = new ArrayList<>();
        nums.addAll(numbers);
        Collections.sort(nums);
        this.numbers = nums;
    }

    private void validate(List<Integer> numbers) {

        Validate.validateSize(numbers);
        Validate.validateDuplication(numbers);

    }

    // TODO: 추가 기능 구현

    //당첨 개수 구하는 메소드
    public int countMatchedNumbers(List<Integer> winningNums) {
        int matchNumCnt = 0;

        for(int i = 0; i < 6; i++){
            if(isMatched(winningNums.get(i),0,5)){
                matchNumCnt += 1;
            }
        }

        return matchNumCnt;
    }


    //보너스 번호 일치 여부
    public boolean checkBonusMatched(int bonusNum,int matchNumCnt) {
        int secondRankCont = 5;
        if (isMatched(bonusNum,0,5) && matchNumCnt == secondRankCont){
            return true;
        }
        return false;
    }

   private boolean isMatched(int key, int low, int high){
        int mid;

        if(low <= high){
            mid = (low + high) /2;

            if(key == numbers.get(mid)) {
                return true;
            } else if (key < numbers.get(mid)) {
                return isMatched(key,low,mid-1);
            } else {
                return isMatched(key,mid+1,high);
            }
        }

        return false;
    }


    //등수를 구하는 메소드 구현
    public Rank getRank(int matchedNumCnt, boolean isbonusMatched) {

        return Rank.getRank(matchedNumCnt,isbonusMatched);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
