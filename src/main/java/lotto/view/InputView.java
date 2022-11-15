package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public static List<Integer> winningNumber=new ArrayList<>();
    private static final String MoneyInput = "구입금액을 입력해 주세요.";
    private static final String NumberInput = "당첨 번호를 입력해 주세요.";
    private static final String BonusInput = "보너스 번호를 입력해 주세요.";

    public InputView(){
    }

    public String startInput(){
        System.out.println(MoneyInput);
        String input = Console.readLine();
        return input;
    }

    public List<Integer> winningNumberInput(){
        System.out.println(NumberInput);
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");
        while(stringTokenizer.hasMoreTokens()){
            winningNumber.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return winningNumber;
    }

    public String BonusNumberInput(){
        System.out.println(BonusInput);
        String input = Console.readLine();
        return input;
    }
}