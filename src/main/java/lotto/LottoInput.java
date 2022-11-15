package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInput {
    private static final String WINING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String BUY_PRICE_INPUT = "구입금액을 입력해 주세요.";
    private static final String REQUIRE_NUMBER = "숫자만 입력해주세요.";
    private static final String REQUIRE_PRICE_NUMBER = "가격은 1000원 단위로 입력해주세요.";
    private static final String LOTTO_SPLIT_CHAR = ",";
    private static final String CHECK_NUMBER_INT = "-?\\d+";
    private static final int CHECK_PRICE_NUMBER = 1000;

    public static Lotto inputWiningNumber(){
        System.out.println(WINING_NUMBER_INPUT);
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbers = Console.readLine().split(LOTTO_SPLIT_CHAR);
        for(String inputNumber: inputNumbers){
            validateInt(inputNumber);
            numbers.add(parseInt(inputNumber));
        }
        return new Lotto(numbers);
    }

    public static int inputBonusNumber(){
        System.out.println(BONUS_NUMBER_INPUT);
        String inputNumber = Console.readLine();

        validateInt(inputNumber);
        return parseInt(inputNumber);
    }

    public static int inputPriceNumber(){
        System.out.println(BUY_PRICE_INPUT);
        String inputNumber = Console.readLine();

        validateInt(inputNumber);
        validatePrice(inputNumber);
        return parseInt(inputNumber);
    }

    private static void validateInt(String inputNumber){
        if(!inputNumber.matches(CHECK_NUMBER_INT)){
            throw new IllegalArgumentException(REQUIRE_NUMBER);
        }
    }

    private static void validatePrice(String inputNumber){
        if(parseInt(inputNumber) % CHECK_PRICE_NUMBER !=0){
            throw new IllegalArgumentException(REQUIRE_PRICE_NUMBER);
        }
    }
}
