package lotto;

import java.util.List;

public class Prize {
    List<Integer> number;
    List<Integer> compareNumber;

    public Prize(List<Integer> number,List<Integer> compareNumber) {
        this.number = number;
        this.compareNumber = compareNumber;
    }

    public List<Integer> getNumber(){
        return this.number;
    }
    public List<Integer> getNumberWithBonusNumber(){
        return this.compareNumber;
    }

}
