package lotto.view;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.NumberConstant.LOTTO_LENGTH;

public class InputValidator {

    private static Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");

    public static int validateInt(String str){
        try {
            int stringToInt = Integer.parseInt(str);
            return stringToInt;
        }catch (Exception e){
            throw new IllegalArgumentException(" 구입 금액은 정수로 입력해야 합니다.");
        }
    }

    public static void validatePrice(int price){
        if (price%1000!=0)
            throw new IllegalArgumentException(" 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    public static void validateLottoNumbers(String lottoNumbers) {
        if (!PATTERN.matcher(lottoNumbers).matches()) {
            throw new IllegalArgumentException(" 로또 숫자를 형식에 맞게 입력해야 합니다.");
        }
    }

    public static void validateDifferentLottoNumbers(List<Integer> lottoNumberList){
        Integer userNumberLen = Math.toIntExact(lottoNumberList.stream().distinct().count());
        if (userNumberLen!=LOTTO_LENGTH){
            throw new IllegalArgumentException(" 중복없는 6가지 수로 입력해야 합니다.");
        }
    }

    public static void validateRangeLottoNumbers(List<Integer> lottoNumberList){
        for (Integer number : lottoNumberList) {
            if (number>45 || number < 1)
                throw new IllegalArgumentException(" 1 ~ 45 수를 입력해야 합니다.");
        }
    }

}
