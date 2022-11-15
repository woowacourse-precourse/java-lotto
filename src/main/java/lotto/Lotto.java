package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if(hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }

    }


    private boolean hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< numbers.size(); i++){
            set.add(numbers.get(i));
        }
        if(set.size() != numbers.size()){
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
    public int result(List<Integer> winningNumber) {
        boolean[] isSame = new boolean[6];
        int count = 0;

        for(int i=0; i<6; i++) {
            if (numbers.contains(winningNumber.get(i))) {
                count++;
            }
        }
        if(count == 5) {
            if(numbers.contains(winningNumber.get(6))){
                return 2;
            }
        }
        return ranking(count);

    }

    private int ranking(int count) {

        if(count == 6) {
            return 1;
        }
        if(count == 5) {
            return 3;
        }
        if(count == 4) {
            return 4;
        }
        if(count == 3) {
            return 5;
        }
        return 6;
    }

    private boolean hasBonusNumber(List<Integer> winningNumber, boolean[] isSame) {
        for(int i=0; i<6; i++) {
            if(isSame[i] == false) {
                if(numbers.get(i) == winningNumber.get(6)) return true;
            }
        }
        return false;
    }

    private List<Integer> isSameWinningNumber(List<Integer> winningNumber, boolean[] isSame) {
        for(int i=0; i<6; i++) {
            if(isSame[i] == false) {
                if(numbers.get(i) == winningNumber.get(6)) return winningNumber;
            }
        }
        return null;
    }



}
