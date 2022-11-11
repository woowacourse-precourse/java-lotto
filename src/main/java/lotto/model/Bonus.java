package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bonus {

    public void checkBonus(String bonusNumber){
        checkBonusNumber(bonusNumber);
        checkBonusRange(bonusNumber);
    }

    public void checkBonusRange(String bonusNumber){
        int bonus = Integer.parseInt(bonusNumber);
        if(bonus>=1 && bonus<=45){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 보너스 번호의 범위에 벗어났습니다.");
    }

    public void checkBonusNumber(String bonusNumber){
        if(isBonusNumber(bonusNumber)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 보너스 번호는 숫자만 가능합니다.");
    }

    public boolean isBonusNumber(String bonusNumber){
        boolean found=false;

        String regex = "^[1-9]{0,1}[0-9]{1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bonusNumber);
        if(matcher.matches()){
            found=true;
        }
        return found;
    }
}
