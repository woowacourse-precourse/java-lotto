package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개 이상입니다.");
        } else if (duplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    private boolean duplicate(List<Integer> numbers){
        boolean result=false;
        HashSet<Integer> removeDuplication = new HashSet<>(numbers);
        if(removeDuplication.size()!= numbers.size()){
            result=true;
        }
        return result;
    }

    void printLotto(){
        System.out.println(numbers);
    }

    int matchWinning(List<Integer> winning) {
        int result = 0;
        for (int winNum: winning) {
            if (numbers.contains(winNum)) {
                result++;
            }
        }
        return result;
    }

    boolean matchBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
