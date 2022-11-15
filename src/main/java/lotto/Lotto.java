package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        DuplicatedNumber(numbers);
        checkOverRange(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void DuplicatedNumber(List<Integer> numbers){
        Set<Integer> checkNumbers = new HashSet<Integer>(numbers);
        if(checkNumbers.size() != numbers.size()) throw new IllegalArgumentException("[ERROR]");
    }

    private void checkOverRange(List<Integer> numbers){
        for(int i =0;i<6;i++){
            if(numbers.get(i) > 46 || numbers.get(i) < 1) throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void getCompareTarget(){
        List<Integer> randomNumbers = Buy.compareRandomLottos();
        List<Integer> winningNumbers = this.numbers;
        comapreNumbers(randomNumbers,winningNumbers);
    }

    public void comapreNumbers(List<Integer> randomNumbers,List<Integer> winningNumbers){
        HashMap<Integer,Integer> result = new HashMap<>();
        int count = 0;
        for(int i =1;i<=randomNumbers.size() / 6;i++){
            result.put(i,0);
        }

        for(int i =0;i<randomNumbers.size()/6;i++){
            count = compareSixNumbers(randomNumbers,winningNumbers,i);
            if(count != 0)
            result.put(count,result.get(count)+1);
        }
            System.out.println(result);
    }

    public int compareSixNumbers(List<Integer> randomNumbers,List<Integer> winningNumbers,int row){
        int count =0;
        List<Integer> seperateRandomLotto = new ArrayList<>();
        for(int j= row*6;j<(row+1)*6;j++){
            int target = randomNumbers.get(j);
            seperateRandomLotto.add(target);
        }

        for(int i =0;i< seperateRandomLotto.size();i++){
            if(seperateRandomLotto.contains(winningNumbers.get(i))){
                count ++;
            }
        }

        return count;
    }

}
    // TODO: 추가 기능 구현

