package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.InputValid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.ViewEnum.*;

public class InputView {

    public static int getUserPriceNumber(){
        System.out.println(NUMBER_OF_USER_PRICE_INPUT_MESSAGE.getMessage());
        String strUserPrice= Console.readLine();
        isValidGetUserPriceNumber(strUserPrice);

        return Integer.parseInt(strUserPrice);
    }

    private static void isValidGetUserPriceNumber(String strUserPrice){
        if(!InputValid.checkPriceUnit(strUserPrice)){
            throw new IllegalArgumentException(EXCEPTED_UNIT_OF_PRICE_MESSAGE.getMessage());
        }
    }

    public static List<Integer> getLottoNumber(){
        System.out.println(LIST_OF_LOTTO_INPUT_MESSAGE.getMessage());
        String strLottoNumber=Console.readLine();
        isValidGetLottoNumber(strLottoNumber);

        List<String> listLottoNumber= Arrays.asList(strLottoNumber.split(","));
        return listLottoNumber
                .stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static void isValidGetLottoNumber(String strLottoNumber){
        if(!InputValid.checkLottoNumber(strLottoNumber)){
            throw new IllegalArgumentException(EXCEPTED_LOTTO_MESSAGE.getMessage());
        }
    }

    public static Integer getBonusNumber(List<Integer> lottoNumber){
        System.out.println(NUMBER_OF_BONUS_INPUT_MESSAGE.getMessage());
        String strBonusNumber=Console.readLine();

        return isValidGetBonusNumber(strBonusNumber,lottoNumber);
    }

    private static int isValidGetBonusNumber(String strBonusNumber,List<Integer> lottoNumber){
        if(!InputValid.checkBonusNumber(strBonusNumber,lottoNumber)){
            throw new IllegalArgumentException(EXCEPTED_LOTTO_MESSAGE.getMessage());
        }
        return Integer.parseInt(strBonusNumber);
    }
}
