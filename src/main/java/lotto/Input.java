package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static int inPayment;
    private static List<Integer> inLottoNum;
    private static int inBonusNum;

    public static int inputPayment() {
        System.out.println("구입 금액을 입력해주세요.");
        try {
            inPayment = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("구입 금액은 정수만 입력할 수 있습니다.");
        }
        return inPayment;
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try {
            String[] inStringArray = Console.readLine().split(",");
            inLottoNum = new ArrayList<Integer>();
            for(String stringNum : inStringArray) {
                int number = Integer.parseInt(stringNum);
                inLottoNum.add(number);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 정수만 입력할 수 있습니다.");
        }
        return inLottoNum;
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            String inString = Console.readLine();
            inBonusNum = Integer.parseInt(inString);
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호는 정수만 입력할 수 있습니다.");
        }
        return inBonusNum;
    }


    

}
