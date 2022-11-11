package lotto.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValid {
    private final static int EXCEPTED_UNIT_OF_PRICE=1000;

    public InputValid() {
    }

    public static boolean checkPriceUnit(String userPrice){
        int isValidUserGameChance;

        try{
            isValidUserGameChance=Integer.parseInt(userPrice)%EXCEPTED_UNIT_OF_PRICE;
        }catch (Exception e){
            return false;
        }

        if(isValidUserGameChance!=0){
            return false;
        }
        return true;
    }

    public static boolean checkLottoNumber(String strLottoNumber){
        List<String> listLottoNumber;
        try {
            listLottoNumber = Arrays.asList(strLottoNumber.split(","));
            listLottoNumber = listLottoNumber.stream().
                    distinct().
                    filter(s -> Integer.parseInt(s) > 0).filter(s -> Integer.parseInt(s) < 46).
                    collect(Collectors.toList());
        }catch (Exception e){
            return false;
        }

        if(listLottoNumber.size()!=6){
            return false;
        }
        return true;
    }
}
