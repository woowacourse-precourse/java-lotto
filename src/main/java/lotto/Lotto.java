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


    public double percentToProfit(double inputMoney, double totalProfit){
        return totalProfit / inputMoney * 100;
    }
    public Integer totalProfit(){
        int result=0;
        for (Rank rank : Rank.values()){
            result += rank.getReward()*rank.getCount();
        }
        return result;
    }

    public void gameConfirm(List<Lotto> lottoList, int bonus){
        for (Lotto lottoNum : lottoList) {
            Integer fixnum = fixNumber(lottoNum);
            if (fixnum==6){
                Rank.FIRST.plusCount();
                continue;
            }
            if (fixnum==5&&lottoNum.contains(bonus)){
                Rank.SECOND.plusCount();
                continue;
            }
            if (fixnum==5){
                Rank.THIRD.plusCount();
                continue;
            }
            if (fixnum==4){
                Rank.FORTH.plusCount();
                continue;
            }
            if (fixnum==3){
                Rank.FIFTH.plusCount();
            }
        }
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
