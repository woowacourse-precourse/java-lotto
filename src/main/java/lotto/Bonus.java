package lotto;

import java.util.List;

public class Bonus {
    boolean including=false;
    public Bonus(List<Integer> lottoNumbers, int bonusNumber){
        for (int i=0;i<6;i++){
            if(lottoNumbers.get(i)==bonusNumber){
                including=true;
            }
        }
    }
    public boolean getBonusCheck() {
        return including;
    }
}
