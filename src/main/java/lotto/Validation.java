package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static Message.ErrorMessage.*;

public class Validation {
    private static final String numberPattern = "^[0-9]+$";

    public static void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public static int numberValidate(String number){
        if(!(Pattern.matches(numberPattern, number))){
            throw new IllegalArgumentException(WRONG_INPUT_TYPE);
        }
        return Integer.parseInt(number);
    }

    public static int moneyValidate(String number){
        int convertNumber = numberValidate(number);

        if(convertNumber % 1000 != 0 || convertNumber < 1000){
            throw new IllegalArgumentException(WRONG_INPUT_MONEY);
        }

        return convertNumber;
    }

    public static Lotto lottoValidate(String lotto){
        String[] split = lotto.split(",");
        List<Integer> makeList = new ArrayList<>();

        for(int i = 0; i<split.length; i++){
            int number = lottoNumberValidate(split[i], makeList);
            makeList.add(number);
        }

        Lotto makeLotto = new Lotto(makeList);

        return makeLotto;
    }

    public static Integer lottoNumberValidate(String number, List<Integer> lottos){
        int convertNumber = numberValidate(number);

        if(convertNumber <= 0 || convertNumber > 45){
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        if(lottos.contains(convertNumber)){
            throw new IllegalArgumentException(NUMBER_DUPLICATE);
        }

        return convertNumber;
    }

    public static int bonusNumberValidate(String number, Lotto lotto){
        int convertNumber = numberValidate(number);

        if(convertNumber <= 0 || convertNumber > 45){
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        if(lotto.containNumbers(convertNumber)){
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }

        return convertNumber;
    }
}
