package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoManager {

    public int countLotto(String inputMoney){
        int money = stringToInteger(inputMoney);
        hasRestError(money);
        MinimumAmountError(money);
        return money / 1000;
    }
    public int stringToInteger(String money) throws IllegalArgumentException{
        return Integer.parseInt(money);
    }

    public void hasRestError(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public void MinimumAmountError(int money){
        if(money < 1000){
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> makeRandomNumbers(int lottoCount){
        List<List<Integer>> numbers = new ArrayList<>();
        int cnt = 0;
        while(cnt > lottoCount){
            List<Integer> randomNumbers = randomNumbers();
            if(isNotDuplication(randomNumbers)){
                Collections.sort(randomNumbers);
                numbers.add(randomNumbers);
                cnt ++;
            }
        }

        return numbers;
    }

    public List<Integer> randomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public boolean isNotDuplication(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size() != numberSet.size()){
            return false;
        }
        return true;
    }

}
