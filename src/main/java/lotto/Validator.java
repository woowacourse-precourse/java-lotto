package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");


    public void ValidatorSix(List<Integer> ValidatorNumber){
        if(ValidatorNumber.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다!");
        }
    }

    public void ValidatorRepeatBan(List<Integer> ValidatorNumber){
        for(Integer integer : ValidatorNumber){
            if(Collections.frequency(ValidatorNumber, integer) > 1){
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

    public static void ValidatorBonusRepeatNumber(List<Integer> ValidatorNumber, int BonusNumber){
        if(ValidatorNumber.contains(BonusNumber)){
            throw new IllegalArgumentException("[ERROR] 중복된 수는 들어올수 없습니다!");
        }
    }

    public void ValidatorBonusRangeNumber(int BonusNumber){
        for(int index = 0; index < BonusNumber; index++){
            if(BonusNumber > 45 || BonusNumber < 0){
                throw new IllegalArgumentException("[ERROR] 1부터~45의 수까지 입력가능합니다");
            }
        }
    }

    public void ValidatorLottoInputList(String NumberInput){
        InputList(NumberInput);
        List<Integer> InputList = InputList(NumberInput);
        ValidatorSix(InputList);
        ValidatorRepeatBan(InputList);
        ValidatorRange(InputList);
    }

    public static List<Integer> InputList(String placeSplit){
        List<Integer> afterSplit = new ArrayList<>();
        String[] split = placeSplit.split(",");

        for(String index : split){
            afterSplit.add(Integer.parseInt(index));
        }
        return afterSplit;
    }

    public void priceDuplicate(int ValueNumber){
        if(ValueNumber % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000단위의 수를 입력하세요");
        }
    }

    public void OnlyNumber(String SValueNumber1){
        if(!NUMBER_PATTERN.matcher(SValueNumber1).matches()){
            throw new IllegalArgumentException(("[ERROR] 숫자만 가능합니다."));

        }

    }

}
