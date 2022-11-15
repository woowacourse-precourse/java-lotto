package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.WinningCount;

import java.util.List;

public class Bonus {
    boolean including=false;
    public Bonus(List<Integer> lottoNumber, int bonusNumber){
        for (int i=0;i<6;i++){
            if(lottoNumber.get(i)==bonusNumber){
                including=true;
            }
        }
    }
    public boolean getBonusCheck() {
        return including;
    }
}
