package lotto;

import java.lang.annotation.Target;
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
        for(int i =1;i<=(randomNumbers.size() / 6)+1;i++){
            result.put(i,0);
        }

        for(int i =0;i<randomNumbers.size()/6;i++){
            count = compareSixNumbers(randomNumbers,winningNumbers,i);
            if(count == 5){
                int bonus = Bonus.bonus;
                count = compareBonus(randomNumbers,bonus,i,count);
                result.put(count,result.get(count)+1);
                continue;
            }
            if(count != 0)
            result.put(count,result.get(count)+1);
//            System.out.println(result);
        }
        printResult(result);
    }

    public int compareBonus(List<Integer> randomNumbers,int bonus,int row,int count) {
        List<Integer> seperateRandomLotto = new ArrayList<>();

        for (int j = row * 6; j < (row + 1) * 6; j++) {
            int target = randomNumbers.get(j);
            seperateRandomLotto.add(target);
        }
        for (int i = 0; i < seperateRandomLotto.size(); i++) {
            if (seperateRandomLotto.contains(bonus)) {
                count = (randomNumbers.size()/6) + 1;
            }
        }
        return count;
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

    public void printResult(HashMap<Integer,Integer> result){
        System.out.println();
        System.out.println(3+"개 일치 (5,000원) -" + result.get(2)+"개");
        System.out.println(4+"개 일치 (50,000원) -" + result.get(3)+"개");
        System.out.println(5+"개 일치 (1,500,000원) -" + result.get(4)+"개");
        System.out.println(5+"개 일치, 보너스 볼 일치 (30,000,000원) -" + result.get(6)+"개");
        System.out.println(6+"개 일치 (2,000,000,000원) -" + result.get(5)+"개");
    }

}
    // TODO: 추가 기능 구현

