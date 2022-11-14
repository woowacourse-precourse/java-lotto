package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private Lotto mainNumbers;
    private Integer bonusNumber;

    public WinningNumber(List<Integer> announcedNumbers) {
        List<Integer> materials = new ArrayList<>();
        for(Integer announcedNumber : announcedNumbers){
            materials.add(announcedNumber);
        }
        mainNumbers = new Lotto(materials);
        bonusNumber = announcedNumbers.get(6);
    }
    public Lotto getMainNumber() {
        List<Integer> materials = new ArrayList<>();
        Lotto sendingLotto;
        for(Integer number : mainNumbers.getLotto()){
            materials.add(number);
        }
        sendingLotto = new Lotto(materials);
        return sendingLotto;
    }

    public Integer getBonusNumber(){
        Integer sendingBonus = this.bonusNumber;
        return sendingBonus;
    }
}
