package lotto.datamodel;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;
    public BonusLotto(int number, List<Integer> winnumbers) {
        reduplication(number, winnumbers);
        range(number);
        this.bonusNumber = number;
    }

    private void reduplication(int number, List<Integer> winnumbers) {
        if(winnumbers.contains(number) == true) {
            throw new IllegalArgumentException();
        }
    }

    private void range(int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException();
        }
    }

}
