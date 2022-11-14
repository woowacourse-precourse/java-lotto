package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Collect, Integer> result = lotteryResult(userLottoTotal, prize, bonus);
        lottoResultOutput(result);
    }
    public static String userPayment () {
        return Console.readLine();
    }
    public static Integer isUserPaymentValid (String userPayment) {
        try {Integer.parseInt(userPayment);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR");
        }
        Integer numberOfLotto = Integer.parseInt(userPayment);
        try {
            if (numberOfLotto%1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
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
    public static Map<Collect, Integer> lotteryResult (List<List<Integer>> userLotto, List<Integer> prize, Integer bonus) {
        Map<Collect, Integer> result = new HashMap<>();
        result.put(Collect.FIRST, 0);
        result.put(Collect.SECOND, 0);
        result.put(Collect.THIRD, 0);
        result.put(Collect.FOURTH, 0);
        result.put(Collect.FIFTH, 0);
        for (List<Integer> lotto : userLotto) {
            Collect resultCollect = Collect.find(lotteryComparison(lotto, prize, bonus));
            if (resultCollect != null) {
                result.put(resultCollect, result.get(resultCollect)+1);
            }
        }

        return result;
    }

    public static Float lotteryComparison(List<Integer> userLotto, List<Integer> prize, Integer bonus) {
        Integer sameLottoCount = 0;
        for ( int i = 0 ; i < userLotto.size() ; i++) {
            if (prize.contains(userLotto.get(i))) {
                sameLottoCount++;
            }
        }
        if (sameLottoCount.equals(5)) {
            Float result = sameLottoCount + isBonus(userLotto, bonus);
            return result;
        }
        return sameLottoCount.floatValue();
    }

    public static Float isBonus(List<Integer> userLotto, Integer bonus) {
        if (userLotto.contains(bonus)) {
            return 0.5f;
        }
        return 0.0f;
    }

    public static void lottoResultOutput(Map<Collect, Integer> lotteryResult) {
        for (Collect rk : Collect.values()) {
            System.out.println(rk.getDescription() + " - " + lotteryResult.get(rk)+"개");
        }
    }
}