package lotto;

import lotto.Enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Utils {

    public static int getPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchase = string2int(readLine());
        return purchase;
    }


    public static List<Integer> getWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = readLine();
        List<Integer> winningNums = parsingInput(input);

        return winningNums;
    }


    public static int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int purchase = string2int(readLine());
        return purchase;
    }

    private static List<Integer> parsingInput(String input) {
        List<Integer> numbers = new ArrayList<>();

        String[] parsed = input.split(",");
        for(String p:parsed){
            numbers.add(string2int(p));
        }

        return numbers;
    }

    public boolean checkLottoType() {
        return true;
    }

    private static int string2int(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TYPE.getMessage(), e);
        }
    }

    public void printResult() {

    }

    private int calYield() {
        return 100;
    }


}
