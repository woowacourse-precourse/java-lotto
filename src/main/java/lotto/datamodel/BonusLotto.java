package lotto.datamodel;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;
    public BonusLotto(int number, List<Integer> winnumbers) {
        reduplication(number, winnumbers);
        this.bonusNumber = number;
    }

    private void reduplication(int number, List<Integer> winnumbers) {
        if(winnumbers.contains(number) == true) {
            throw new IllegalArgumentException();
        }
    }


}
