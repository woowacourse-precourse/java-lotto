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



}
