package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoService.*;
import static lotto.Validator.isValidFormat;

public class ConsoleManager {

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



}
