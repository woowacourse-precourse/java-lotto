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
        int bonusNum = string2int(readLine());
        return bonusNum;
    }

    private static List<Integer> parsingInput(String input) {
        List<Integer> numbers = new ArrayList<>();

        String[] parsed = input.split(",");
        for(String p:parsed){
            numbers.add(string2int(p));
        }

        return numbers;
    }

    private static int string2int(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TYPE.getMessage(), e);
        }
    }

    public static void printResult(List<Integer> results) {
        System.out.println("당첨 통계\n---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", results.get(5)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", results.get(4)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", results.get(3)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", results.get(2)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", results.get(1)));
    }

    public static void printYield(double yield) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", yield));
    }

}
