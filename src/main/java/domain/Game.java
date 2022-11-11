package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static final int LottoPrice = 1000;

    public static String winningNumbers_Input;
    public static int bonusNumber;
    public static int paymentAmount;
    private static List<Integer> winning_numbers;

    public static void changeToInt(String numbers) {
        String[] str = numbers.split(",");
        List<String> number = List.of(str);
        List<Integer> newforms = number.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Game.winning_numbers = newforms;
    }

    public static String read_WinningNumbers() {
        System.out.print("당첨번호를 입력해주세요.");
        winningNumbers_Input = Console.readLine();
        return winningNumbers_Input;
    }

    public static void read_buyingLottoAmount() {
        System.out.print("구입 금액을 입력해주세요." + "\n");
        paymentAmount = Integer.parseInt(Console.readLine());
    }

    public static void read_bonusNumber() {
        System.out.print("보너스 번호를 입력해주세요." + "\n");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public static int getLottoCount() {
        return paymentAmount / LottoPrice;
    }
}
