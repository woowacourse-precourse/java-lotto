package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        Integer numOfLotto = isUserPaymentValid(userPayment());
        System.out.println(numOfLotto+"개를 구매했습니다.");
        List<List<Integer>> userLottoTotal = userLottoNumber(numOfLotto);
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> prize = prizeNumber(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus = bonusNumber(Console.readLine());
    }

    public static String userPayment () {
        return Console.readLine();
    }

    public static Integer isUserPaymentValid (String userPayment) {
        try {
            Integer.parseInt(userPayment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
        Integer numberOfLotto = Integer.parseInt(userPayment);
        try {
            if (numberOfLotto%1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
        return numberOfLotto/1000;
    }

    public static List<List<Integer>> userLottoNumber (Integer numOfLotto) {
        List<List<Integer>> userLotto = new ArrayList<>();
        for ( int i = 0 ; i < numOfLotto ; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoNumberResult = new Lotto(lottoNumber);
            List<Integer> lottoNum = new ArrayList<>(lottoNumberResult.getNumbers());
            Collections.sort(lottoNum);
            System.out.println(lottoNum);
            userLotto.add(lottoNumberResult.getNumbers());
        }
        return userLotto;
    }

    public static List<Integer> prizeNumber (String prizeInput) {
        List<String> list = Arrays.asList(prizeInput.split(","));
        List<Integer> prizeNumberResult = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return prizeNumberResult;
    }

    public static Integer bonusNumber (String bonusInput) {
        return Integer.parseInt(bonusInput);
    }
}
