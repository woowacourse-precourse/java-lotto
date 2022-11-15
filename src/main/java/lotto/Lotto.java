package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static int bonusNum;
    private static List<Integer> winNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        for(int i = 0; i < 5;i++){
            this.winNumbers.add(0);
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        int frequency=0;
        for(int i = 0; i<numbers.size();i++){
            frequency = Collections.frequency(numbers, numbers.get(i));
            if(frequency != 1){
                System.out.println("[ERROR] 당첨번호를 중복되지 않게 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void getBonus(int bonus){
        if(Collections.frequency(numbers, bonus) != 0){
            System.out.println("[ERROR] 보너스번호를 중복되지 않게 입력해주세요.");
            throw new IllegalArgumentException();
        }
        this.bonusNum = bonus;
    }

    public void lottoNumberCompare(List<Integer> lotto){
        int frequencyNumber=0;
        boolean bonusNumFrequency = false;
        for(int i = 0; i<lotto.size();i++){
            if(Collections.frequency(numbers, lotto.get(i)) == 1){
                frequencyNumber++;
            }
        }
        if(Collections.frequency(lotto, this.bonusNum) == 1){
            bonusNumFrequency = true;
        }
        lottoMoney(frequencyNumber, bonusNumFrequency);
    }

    private void lottoMoney(int frequencyNumber, boolean bonusFrequency){

    }

}
