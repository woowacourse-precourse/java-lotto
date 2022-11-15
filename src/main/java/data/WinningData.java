package data;

import java.util.ArrayList;
import java.util.List;

public class WinningData {
    private boolean isHavingBonus;
    private int winningNumberCount;


    public WinningData() {
        isHavingBonus = false;
        winningNumberCount = 0;
    }

    public void plusBonusNumberCount(){
        winningNumberCount++;
    }

    public void checkBonusNumber(){
        isHavingBonus = true;
    }

    public boolean getIsHavingBonus(){
        return isHavingBonus;
    }

    public int getBonusNumberCount(){
        return winningNumberCount;
    }
}
