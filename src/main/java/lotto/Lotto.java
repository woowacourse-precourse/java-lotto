package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> numbers2 = new ArrayList<>(numbers.size());
        for (int number : numbers) {
            numbers2.add(number);
        }
        Collections.sort(numbers2);
        this.numbers = numbers2;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
        }
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 6){
            throw new IllegalArgumentException("로또 번호에는 중복이 없어야 합니다.");
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

    public double percentToProfit(double inputmoney, double totalprofit){
        double perscent = totalprofit / inputmoney * 100;
        return perscent;
    }
    public Integer totalProfit(HashMap<Integer, Integer> winNumbers){
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


    public HashMap<Integer, Integer> gameConfirm(List<Lotto> lottoList, int bonus){
        HashMap<Integer, Integer> winNumbers = getwinnerSetMap();
        for (Lotto lottoNum : lottoList) {
            Integer fixnum = fixNumber(lottoNum);
            if (fixnum==5&&lottoNum.contains(bonus)){
                winNumbers.put(7,winNumbers.get(7)+1);//2등
                continue;
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

    private Integer fixNumber(Lotto lottoNum){
        int winNum = 0;
        for (int num : numbers){
            if (lottoNum.contains(num)){
                winNum++;
            }
        }
        return winNum;
    }

    private boolean contains(int num) {
        return getNumbers().contains(num);
    }


}
