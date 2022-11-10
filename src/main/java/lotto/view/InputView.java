package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.InputValid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String NUMBER_OF_USER_PRICE_INPUT_MESSAGE="구입금액을 입력해 주세요.";
    private static final String LIST_OF_LOTTO_INPUT_MESSAGE="당첨 번호를 입력해 주세요.";

    public static int getUserPriceNumber(){
        System.out.println(NUMBER_OF_USER_PRICE_INPUT_MESSAGE);
        String strUserPrice= Console.readLine();
        int userPrice=Integer.parseInt(strUserPrice);

        InputValid.checkPriceUnit(userPrice);
        return userPrice;
    }

    public static List<Integer> getLottoNumber(){
        System.out.println(LIST_OF_LOTTO_INPUT_MESSAGE);
        String strLottoNumber=Console.readLine();
        List<String> listLottoNumber= Arrays.asList(strLottoNumber.split(","));

        return listLottoNumber
                .stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
