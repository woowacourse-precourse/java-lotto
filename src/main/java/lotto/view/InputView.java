package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int receivePurchaseMoney(){
        System.out.println("구입 금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static String receiveWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.next();
    }

    public static List<Integer> getListOfInteger(){
        return Arrays.stream(receiveWinningNumbers().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public static int receiveBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
