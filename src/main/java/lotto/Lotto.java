package lotto;

import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    /**
     * 6개 일치 -> 1등
     * 5개 일치 + bonus -> 2등
     * 5개 일치 -> 3등
     * 4개 일치 -> 4등
     * 3개 일치 -> 5등
     *
     * @return
     */
    public void lottoOutput(){
        //복권 당첨 확인

        //복권 당첨 금액 확인

        //수익율 계산
    }
    private Integer totalProfit(HashMap<Integer, Integer> winNumbers){
        int result=0;
        HashMap<Integer, Integer> winningMoney = getwinningMoney();
        for (int key :winNumbers.keySet()){
            result += winNumbers.get(key)*winningMoney.get(key);
        }
        return result;
    }
    private HashMap<Integer, Integer> getwinningMoney(){
        HashMap<Integer, Integer> winningMoney = new HashMap<>();
        winningMoney.put(0,0);
        winningMoney.put(1,0);
        winningMoney.put(2,0);
        winningMoney.put(3,5000);//5
        winningMoney.put(4,50000);//4
        winningMoney.put(5,1500000);//3
        winningMoney.put(6,2000000000);//1
        winningMoney.put(7,30000000);//2
        return winningMoney;
    }


    public HashMap<Integer, Integer> gameConfirm(List<List<Integer>> lottoList, int bonus){
        HashMap<Integer, Integer> winNumbers = getwinnerSetMap();
        for (List<Integer> lottoNum : lottoList) {
            Integer fixnum = fixNumber(lottoNum);
            if (fixnum==5&&lottoList.contains(bonus)){
                winNumbers.put(7,winNumbers.get(7)+1);//2등
            }
            winNumbers.put(fixnum,winNumbers.get(fixnum)+1);
        }
        return winNumbers;
    }

    private static HashMap<Integer, Integer> getwinnerSetMap() {
        HashMap<Integer, Integer> winNumbers = new HashMap<>();
        winNumbers.put(0,0);
        winNumbers.put(1,0);
        winNumbers.put(2,0);
        winNumbers.put(3,0);//5
        winNumbers.put(4,0);//4
        winNumbers.put(5,0);//3
        winNumbers.put(6,0);//1
        winNumbers.put(7,0);//2
        return winNumbers;
    }

    private Integer fixNumber(List<Integer> lottoNum){
        int winNum = 0;
        for (int num : numbers){
            if (lottoNum.contains(num)){
                winNum++;
            }
        }
        return winNum;
    }


}
