package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoErrorCheck.*;

public class LottoInput {
    public static int howMuchLottoBuy(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        moneyErrorCheck(money);

        return Integer.parseInt(money)/1000;
    }
    public static List<Integer> winningNumberInput(){
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String number = readLine();
        List<String> numbers = Arrays.asList(number.split(","));

        winningNumberErrorCheck(numbers);

        List<Integer> winningNumber = new ArrayList<>();

        for(int i = 0 ;  i < numbers.size() ;i++)
            winningNumber.add(Integer.valueOf(numbers.get(i)));

        return winningNumber;
    }
    public static Integer bonusNumberInput(){
        System.out.println("\n보너스 번호를 입력해 주세요.");

        String number = readLine();

        bonusNumberErrorCheck(number);

        Integer bonusNumber = Integer.valueOf(number);

        return bonusNumber;
    }
}
