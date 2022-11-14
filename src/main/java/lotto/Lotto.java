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
            } else if (key > numbers.get(mid)) {
                return isMatched(key,mid+1,high);
            }
        }

        return false;
    }


    //등수를 구하는 메소드 구현
    public Rank getRank(List<Integer> winningNums) {
        int bonusNumIdx = 6;

        int matchedNumCnt = countMatchedNumbers(winningNums);
        boolean isbonusMatched = checkBonusMatched(winningNums.get(bonusNumIdx),matchedNumCnt);
        return Rank.getRank(matchedNumCnt,isbonusMatched);
    }
    

}
