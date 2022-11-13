package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        printInputMoneyComment();
        Money money = new Money(toInt(Console.readLine()));
        LottoGroups lottos = new LottoGroups(createLottos(money.getNumberToPublishLottos()));

        lottos.printAmountOfLottosComment();
        lottos.printAllLottos();

        printInputWinningNumbersComment();
        List<Integer> winningNumbers = toIntegers(spilt(Console.readLine()));

        printInputBonusNumberComment();
        Numbers numbers = new Numbers(winningNumbers, toInt(Console.readLine()));
    }

    private static void printInputMoneyComment() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static List<Lotto> createLottos(int numberToPublishLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberToPublishLottos; i++) {
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static void printInputWinningNumbersComment() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void printInputBonusNumberComment() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] spilt(String input){
        return input.split(",");
    }

    private static List<Integer> toIntegers(String[] input){
        List<Integer> result = new ArrayList<>();
        try {
            Arrays.stream(input).forEach(item -> result.add(Integer.parseInt(item)));
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는  숫자를 ,(쉼표)로 구분하여 작성해야 합니다.");
        }
        return result;
    }
}
