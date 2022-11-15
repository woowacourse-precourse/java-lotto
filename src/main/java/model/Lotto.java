package model;

import static model.Constant.BOUNDS;
import static model.Constant.END_INCLUSIVE;
import static model.Constant.MINIMUM_LOTTO_PRICE;
import static model.Constant.REPETITION;
import static model.Constant.START_INCLUSIVE;
import static model.Constant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import controller.StartLotto;
import error.Error;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import view.Message;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != BOUNDS.constant) {
            Error.message(Error.INADEQUATE_LOTTO_NUMBER);
        }
        numbers.forEach(number -> {
            if (number < START_INCLUSIVE.constant || number > END_INCLUSIVE.constant) {
                Error.message(Error.NUMBER_OUT_OF_BOUNDS);
            }
            if (Collections.frequency(numbers, number) != REPETITION.constant) {
                Error.message(Error.LOTTO_NUMBER_REPETITION);
            }
        });
    }

    public static List<Lotto> getLotto(int lottoQuantity) {
        List<Lotto> lottos = getRandomNumber(lottoQuantity);
        printLotto(lottos);
        return lottos;
    }

    private static void printLotto(List<Lotto> lottos) {
        System.out.printf((Message.PURCHASE_QUANTITY) + "%n", lottos.size());
        lottos.stream()
                .map(lotto -> lotto.numbers.toString())
                .forEach(System.out::println);
    }

    private static List<Lotto> getRandomNumber(int lottoQuantity) {
        return IntStream.range(ZERO.constant, lottoQuantity)
                .mapToObj(number -> Randoms
                        .pickUniqueNumbersInRange(START_INCLUSIVE.constant, END_INCLUSIVE.constant, BOUNDS.constant))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static void lottoQuantity(int userInput) {
        StartLotto.lottoQuantity = userInput / MINIMUM_LOTTO_PRICE.constant;
    }

    public static int countMatchNumber(Lotto userNumber, Lotto winNumber) {
        return (int) userNumber.numbers.stream()
                .mapToInt(number -> number)
                .filter(winNumber.numbers::contains)
                .count();
    }

    public static boolean checkBonusNumber(Lotto userNumber, int bonusNumber) {
        return userNumber.numbers.contains(bonusNumber);
    }

    public boolean checkContainNumber(int userInput) {
        return numbers.contains(userInput);
    }

}