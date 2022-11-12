package lotto.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValid {
    private final static int EXCEPTED_UNIT_OF_PRICE=1000;
    private final static int MAX_NUMBER_OF_LOTTO=45;
    private final static int MIN_NUMBER_OF_LOTTO=1;
    public InputValid() {
    }

    public static boolean checkPriceUnit(String userPrice){
        int isValidUserGameChance=tryCheckPriceUnit(userPrice);

        if(isValidUserGameChance!=0){
            return false;
        }
        return true;
    }

    private static int tryCheckPriceUnit(String userPrice){
        try{
            return Integer.parseInt(userPrice)%EXCEPTED_UNIT_OF_PRICE;
        }catch (Exception e){
            return 1;
        }
    }

    public static boolean checkLottoNumber(String strLottoNumber){
        List<String> listLottoNumber=tryCheckLottoNumber(strLottoNumber);

        if(listLottoNumber.size()!=6){
            return false;
        }
        return true;
    }

    private static List<String> tryCheckLottoNumber(String strLottoNumber){
        try {
            List<String> listLottoNumber = Arrays.asList(strLottoNumber.split(","));

            return listLottoNumber.stream().
                    distinct().
                    filter(s -> Integer.parseInt(s) >= MIN_NUMBER_OF_LOTTO).
                    filter(s -> Integer.parseInt(s) <= MAX_NUMBER_OF_LOTTO).
                    collect(Collectors.toList());

        }catch (Exception e){
            return Arrays.asList("");
        }
    }
    public static boolean checkBonusNumber(String strBonusNumber,List<Integer> lottoNumber){
        int bonusNumber=tryCheckBonusNumber(strBonusNumber);
        if(!distinctBonusNumberOfLottoNumber(bonusNumber,lottoNumber)){
            return false;
        }

        if(bonusNumber>=MIN_NUMBER_OF_LOTTO&&bonusNumber<=MAX_NUMBER_OF_LOTTO){
            return true;
        }
        return false;
    }

    private static int tryCheckBonusNumber(String strBonusNumber){
        try {
            return Integer.parseInt(strBonusNumber);
        }catch (Exception e){
            return 0;
        }
    }

    private static boolean distinctBonusNumberOfLottoNumber(int bonusNumber,List<Integer> lottoNumber)
    {
        return !lottoNumber.contains(bonusNumber);
    }
}
