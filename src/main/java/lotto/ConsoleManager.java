package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoService.*;
import static lotto.Validator.isValidFormat;

public class ConsoleManager {
    public static void playGame(){
        printPurchaseMoney();
        int money = getMoney();
        int count = calculateLotto(money);
        HashMap<Integer, List<Integer>> lotties = makeLotto(count);
        printLotties(count, lotties);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        HashMap<Integer, List<Integer>> compareResult = calculateCompareResult(count, lotties, winningNumbers, bonusNumber);
        HashMap<Integer, Integer> rankResult = calculateRank(compareResult, count);
        printResult(rankResult);
        double doubleTypeRateOfReturn = calculateRateOfReturn(rankResult, money);
        printRateOfReturn(doubleTypeRateOfReturn);
    }

    public static void printPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static int getMoney(){
        String money = Console.readLine();
        if (!Validator.isAllNumber(money)){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다");
        }
        return Integer.parseInt(money);
    }
    public static void printLotties(int count, HashMap<Integer, List<Integer>> lotties){
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(lotties.get(i));
        }
    }

    public static void printWriteWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> getWinningNumbers(){
        printWriteWinningNumber();
        String string = Console.readLine();
        if (!isValidFormat(string)){
            throw new IllegalArgumentException("올바른 당첨 번호 입력 형식이 아닙니다.");
        }
        List<Integer> winningNumbers = Arrays.asList(string.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public static void printWriteBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static int getBonusNumber(){
        printWriteBonusNumber();
        String string = Console.readLine();
        if (!Validator.isAllNumber(string)){
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(string);
    }

    public static void printResult(HashMap<Integer, Integer> ranks){
        System.out.printf("3개 일치 (5,000원) - %d개%n", ranks.get(5));
        System.out.printf("4개 일치 (50,000원) - %d개%n", ranks.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", ranks.get(3));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", ranks.get(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", ranks.get(1));
    }

    public static void printRateOfReturn(double doubleTypeRateOfReturn){
        String rateOfReturn = String.format("%.1f", doubleTypeRateOfReturn);
        String formattedRateOfReturn = "";
        int count = 0;
        for (int i = rateOfReturn.length() - 1; i >= 0; i--) {
            if (i == rateOfReturn.length() - 1 || i == rateOfReturn.length() - 2){
                formattedRateOfReturn += rateOfReturn.charAt(i);
                continue;
            }
            if (count == 3){
                formattedRateOfReturn += ",";
                count = 0;
            }
            formattedRateOfReturn += rateOfReturn.charAt(i);
            count++;
        }
        String finalRateOfReturn = "";
        for (int i = formattedRateOfReturn.length()-1; i >= 0; i--) {
            finalRateOfReturn += formattedRateOfReturn.charAt(i);
        }
        System.out.printf("총 수익률은 %s%%입니다.",finalRateOfReturn);
    }

}
