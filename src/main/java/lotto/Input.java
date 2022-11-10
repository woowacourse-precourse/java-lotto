package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Input {

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
//        return Console.readLine(); 제출 시 바꾸기
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
//        return Console.readLine(); 제출 시 바꾸기
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
//        return Console.readLine(); 제출 시 바꾸기
        return scanner.nextLine();
    }

}
