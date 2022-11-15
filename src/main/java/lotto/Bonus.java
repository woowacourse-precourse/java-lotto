package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bonus {
    public static int bonus;

    public Bonus(int userBonus){

        this.bonus = userBonus;
        checkOverRange(bonus);
    }

    private void checkOverRange(int bonus){
            if(bonus > 46 || bonus < 1) throw new IllegalArgumentException("[ERROR]");
    }

}
