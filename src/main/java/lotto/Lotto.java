package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        doubleCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static void doubleCheck(List<Integer> numbers){
        for(int i = 0; i < numbers.size();i++){
            if(numbers.contains(numbers.get(i)) && numbers.indexOf(numbers.get(i)) != i ){
                throw new IllegalArgumentException();
            }
        }
    }
    public int[] checkWin() {
        LottoWin lottoWin = LottoWin.getInstance();
        List<Integer> winNumber = lottoWin.getLottoNum();
        final int nomalSameIndex = 0;
        final int bounsSameIndex = 1;
        int[] sameCnt = new int[2];
        for(int i = 0; i<this.numbers.size() -1; i++){
            if(winNumber.contains(this.numbers.get(i))){
                sameCnt[nomalSameIndex] += 1;
            }
        }
        if(winNumber.contains(this.numbers.get(this.numbers.size()-1))){
            sameCnt[bounsSameIndex] += 1;
        }
        return sameCnt;
    }

    public int[] expenseWithProfit(int[] sameCnt){
        int[] returnData = {1000,0};
        int[] profitTable = {0,0,0,5000,50000,1500000,30000000,2000000000};
        returnData[1] = profitTable[sameCnt[0]];
        if(sameCnt[0] == 5){
            if(sameCnt[1] == 0){
                returnData[1] = profitTable[sameCnt[0]];
            }else if(sameCnt[1] == 1){
                returnData[1] = profitTable[sameCnt[0]+1];
            }
        } else if(sameCnt[0] == 6){
            returnData[1] = profitTable[sameCnt[0]+1];
        }
        return returnData;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
