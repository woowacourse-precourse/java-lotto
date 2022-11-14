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
            throw new IllegalArgumentException("[ERROR]로또는 1~45사이의 숫자 6개여야 합니다.");
        }
        for (int num : numbers){
            if (num <1 || num>45){
                throw new IllegalArgumentException("[ERROR]로또는 1~45사이의 숫자 6개여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현

    //당첨 개수 구하는 메소드
    public int countMatchNumbers(List<Integer> winningNums) {
        int matchNumCnt = 0;

        for(int num : winningNums){
            if(isMatched(num,0,winningNums.size()-1)){
                matchNumCnt += 1;
            }
        }


        return matchNumCnt;
    }

    //보너스 번호 일치 여부부

   private boolean isMatched(int key, int low, int high){
        int mid;

        if(low <= high){
            mid = (low + high) /2;

            if(key == numbers.get(mid)) {
                return true;
            } else if (key < numbers.get(mid)) {
                return isMatched(key,low,mid-1);
            } else if (key > numbers.get(mid)) {
                return isMatched(key,mid+1,high);
            }
        }

        return false;
    }


    //당첨 통계 메소드 구현

    

}
