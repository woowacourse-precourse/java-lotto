package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.enums.Error.*;

public class User extends Exception {

    private static final String INPUT_PURCHASEAMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTONUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public static String askPurchaseAmount() {
        System.out.println(INPUT_PURCHASEAMOUNT);
        return Console.readLine();
    }

    public static Integer convertToInteger(String input) {

        Pattern zeroToNine = Pattern.compile("^[0-9]*$");
        if (zeroToNine.matcher(input).matches()) {
            return checkMonetaryUnit(Integer.parseInt(input));
        }
        return 0;
    }

    public static Integer checkMonetaryUnit(Integer money) {
        if (money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException(ER_MONETARYUNIT.getMessage());
        }
        return money;
    }

    public static List<Integer> lottoNumberReceiveInput() {
        System.out.println(INPUT_LOTTONUMBERS);
        String[] lineTest = Console.readLine().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int length = 0; length < lineTest.length; length++) {
            try {
                lottoNumbers.add(Integer.parseInt(lineTest[length]));
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(ER_STRINGCHECK_SIXNUMBERS.getMessage());
            }
        }
        new Lotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUSNUMBER);
        try {
            String inputNumber = Console.readLine();
            Integer bonusNumber = Integer.parseInt(inputNumber);
            return bonusNumber;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ER_MONETARYUNIT_ONENUMBER.getMessage());
        }
    }

    public static Integer bonusNumberRangeCheck(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ER_NUMBER_RANGE.getMessage());
        }
        return number;
    }
    public static void bonusNumberCheckInLottoNumber(List<Integer> lottoNumber , Integer bonusNumber){
        if(lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ER_BONUSNUMBERINLOTTONUMBER.getMessage());
        }
    }




}