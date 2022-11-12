package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Validator {



    public void ValidatorSix(List<Integer> ValidatorNumber){
        if(ValidatorNumber.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다!");
        }
    }

    public void ValidatorRepeatBan(List<Integer> ValidatorNumber){
        for(Integer integer : ValidatorNumber){
            if(Collections.frequency(Collections.singleton(integer), ValidatorNumber) > 1){
                throw new IllegalArgumentException("[ERROR] 중복된 수는 들어올수 없습니다!");
            }
        }
    }

    public void ValidatorRange(List<Integer> ValidatorNumber){
        for(Integer integer : ValidatorNumber){
            if(integer > 45 || integer < 0){
                throw new IllegalArgumentException("[ERROR] 1부터~45의 수까지 입력가능합니다!");
            }
        }
    }

    public void ValidatorBonusRepeatNumber(List<Integer> ValidatorNumber, String BonusNumber){
        if(ValidatorNumber.contains(BonusNumber)){
            throw new IllegalArgumentException("[ERROR] 중복된 수는 들어올수 없습니다!");
        }
    }

    public void ValidatorBonusRangeNumber(List<Integer> BonusNumber){
        for(Integer integer : BonusNumber){
            if(integer > 45 || integer < 0){
                throw new IllegalArgumentException("[ERROR] 1부터~45의 수까지 입력가능합니다");
            }
        }
    }

    public void ValidatorLottoInputList(String NumberInput){
        List<Integer> InputList = InputList(NumberInput);
        ValidatorSix(InputList);
        ValidatorRepeatBan(InputList);
        ValidatorRange(InputList);
    }

}
