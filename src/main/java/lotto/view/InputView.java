package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.InputValid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String NUMBER_OF_USER_PRICE_INPUT_MESSAGE="구입금액을 입력해 주세요.";
    private static final String LIST_OF_LOTTO_INPUT_MESSAGE="당첨 번호를 입력해 주세요.";
    private final static String EXCEPTED_UNIT_OF_PRICE_MESSAGE="[ERROR] 1,000원 단위의 슷자만 입력 가능합니다.";
    private final static String EXCEPTED_LOTTO_MESSAGE="[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다.";

    public static int getUserPriceNumber(){
        System.out.println(NUMBER_OF_USER_PRICE_INPUT_MESSAGE);
        String strUserPrice= Console.readLine();
        isValidGetUserPriceNumber(strUserPrice);

        return Integer.parseInt(strUserPrice);
    }

    public static List<Integer> getLottoNumber(){
        System.out.println(LIST_OF_LOTTO_INPUT_MESSAGE);
        String strLottoNumber=Console.readLine();
        isValidGetLottoNumber(strLottoNumber);

        List<String> listLottoNumber= Arrays.asList(strLottoNumber.split(","));
        return listLottoNumber
                .stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static void isValidGetUserPriceNumber(String strUserPrice){
        if(!InputValid.checkPriceUnit(strUserPrice)){
            System.out.println(EXCEPTED_UNIT_OF_PRICE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void isValidGetLottoNumber(String strLottoNumber){
        if(!InputValid.checkLottoNumber(strLottoNumber)){
            System.out.println(EXCEPTED_LOTTO_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
