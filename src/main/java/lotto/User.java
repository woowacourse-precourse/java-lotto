package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class User {
    static String lottoPayment;
    static int lottoAmount;
    static List<Integer> guess;
    static int bonus;
    static List<List<Integer>> allLottos;

    // get amount of lottos users would buy
    public static void buyLotto() throws IllegalArgumentException {
        try {
            lottoPayment = Console.readLine();
            validatePayment(lottoPayment);
            System.out.println();
            lottoAmount = Integer.valueOf(lottoPayment) / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 1000원 단위입니다.");
        }
    }

    public static void makeLotto() {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        allLottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(userLotto);
            allLottos.add(userLotto);
        }
        System.out.println();
    }


    public static void guessLotto() {
        try {
            List<String> userGuessLotto = Arrays.asList(Console.readLine().split(",", 6));
            System.out.println();
            guess = userGuessLotto.stream().map(Integer::parseInt).collect(Collectors.toList());
            new Lotto(guess);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 당첨번호는 1부터 45까지 중복없는 6가지 숫자여야 합니다.");
        }
    }


    public static void guessBonus() {
        try {
            bonus = Integer.valueOf(Console.readLine());
            Lotto.validateOne(bonus);
            System.out.println();
            Lotto.validateBonusDuplicate(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private static void validatePayment(String lottoPayment) throws IllegalArgumentException {
        if (Integer.valueOf(lottoPayment) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
