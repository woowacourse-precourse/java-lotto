package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static List<List<Integer>> buyLotto(int account , int LOTTO_PRICE){
        List<List<Integer>> lottos = new ArrayList<>();
        while (account > 0) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> collect = list.stream()
                    .sorted(Comparator.comparing(Integer::intValue))
                    .collect(Collectors.toList());
            System.out.println(list);
            lottos.add(collect);
            account -= LOTTO_PRICE;
        }
        return lottos;
    }

    public static Set<Integer> setWinnerNumber(String input) {
        Set<Integer> winnerNumber = new HashSet<>();
        // 입력 받은 당첨 번호 검증
        if(validWinnerNumber(input)){
            winnerNumber = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        }
        if(winnerNumber.size() == 6){
            System.out.println(input);
            return winnerNumber;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }

    private static boolean validWinnerNumber(String input) {
        // 정규표현식 1 ~ 45 의 수 확인하기 -> 숫자 검증 로직을 별도 생성
        validRegex(input);
        // 입력 받은 당첨 번호의 값이 1~45 사이인지 검증
        validNumberRange(input);
        return true;
    }

    private static void validNumberRange(String input) {
        Stream.of(input.split(",")).map(Integer::parseInt).forEach(x-> {
            if (x < 1 || x > 45) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
            }
        });
    }

    private static boolean validRegex(String input) {
        if(Pattern.matches("((\\d?\\d,){5}\\d?\\d)", input)){
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }

    public static int setBonusNumber(Set<Integer> winnerNumber , String input) {
        int bonusNumber = 0;
        if(validBonusNumber(input)){
            bonusNumber =  Integer.parseInt(input);
        }
        if(winnerNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
        }
        if(bonusNumber >= 1 && bonusNumber <= 45){
            System.out.println(input);
            return bonusNumber;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }
    private static boolean validBonusNumber(String input) {
        if(Pattern.matches("\\d?\\d", input)){
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }

    public static List<List<Integer>> checkLotto(List<List<Integer>> lottos, Set<Integer> winnerNumber, int bonusNumber) {
        List<List<Integer>> resultLotto = new ArrayList<>();
        lottos.forEach(lotto -> {
            resultLotto.add(checkNumber(lotto, winnerNumber, bonusNumber));
        });
        return resultLotto;
    }

    private static List<Integer> checkNumber(List<Integer> lotto, Set<Integer> winnerNumber, int bonusNumber) {
        AtomicInteger rightNumbers = new AtomicInteger();
        AtomicInteger rightBonusNumber = new AtomicInteger();
        lotto.forEach(number -> {
            if(winnerNumber.contains(number)){
                rightNumbers.getAndIncrement();
            }
            if (bonusNumber == number) {
                rightBonusNumber.getAndIncrement();
            }
        });
        return List.of(rightNumbers.intValue(), rightBonusNumber.intValue());
    }

    public static int[] calResult(List<List<Integer>> result) {
        int[] rightResult = {0, 0, 0, 0, 0, 0, 0 , 0};

        result.forEach(lotto -> {
            int rightNumber = lotto.get(0);
            int bonusNumber = lotto.get(1);
            if(bonusNumber >= 1){
                rightResult[rightNumber+1]++;
            }
            if(bonusNumber >= 6){
                rightResult[rightNumber+1]++;
            }
            if (bonusNumber == 0) {
                rightResult[rightNumber]++;
            }
        });

        return rightResult;
    }

    public static float calYield(int[] sumResult , int account) {
        double total = 0;

        int[] value = {0, 0, 0, 5000, 50000, 1500000, 30000000 , 2000000000};
        for (int i = 3; i <= 6; i++) {
            if(sumResult[i] > 0){
                total += (sumResult[i] * value[i]);
            }
            if (sumResult[5] >= 1 && sumResult[i] > 0) {
                total += (sumResult[i] * value[6]);
            }
            if (sumResult[6] >= 1){
                total += (sumResult[i] * value[7]);
            }
        }

        float yield =  ((float) total / account) * 100;
        return yield;
    }
}
