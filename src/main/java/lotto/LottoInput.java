package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoErrorCheck.*;

public class LottoInput {
    private static final String HOWMUCH_BUY = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_SEPARATOR = ",";
    public static int howMuchLottoBuyInput(){
        System.out.println(HOWMUCH_BUY);
        String money = readLine();

        moneyErrorCheck(money);

        return Integer.parseInt(money) / LOTTO_PRICE;
    }
    public static List<Integer> winningNumberInput(){
        System.out.println("\n"+WINNING_NUMBER_INPUT);

        String number = readLine();
        List<String> numbers = Arrays.asList(number.split(NUMBER_SEPARATOR));

        winningNumberErrorCheck(numbers);

        List<Integer> winningNumber = new ArrayList<>();

        for(int i = 0 ;  i < numbers.size() ;i++)
            winningNumber.add(Integer.valueOf(numbers.get(i)));

        return winningNumber;
    }
    public static Integer bonusNumberInput(){
        System.out.println("\n"+BONUS_NUMBER_INPUT);

        String number = readLine();

        bonusNumberErrorCheck(number);

        Integer bonusNumber = Integer.valueOf(number);

        return bonusNumber;
    }
}
