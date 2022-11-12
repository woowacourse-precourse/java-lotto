package ui;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

import static values.Message.Error.*;

public class LottoUi {
    private static final int LOTTO_PRICE = 1000;

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
        validateNumbersRange(numbers);
    }


    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        List<Integer> duplicationRemoved = numbers.stream().distinct().collect(Collectors.toList());

        if (duplicationRemoved.size() != 6) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (!(num >= 1 && num <= 45)) {
                throw new IllegalArgumentException(RANGE_ERROR);
            }
        });
    }

    public static int getLottoCnt(){
        int lottoCnt = getMoney()/ LOTTO_PRICE;
        return lottoCnt;
    }

    private static int getMoney(){
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);

        return money;
    }

    private static void validateMoney(int money){
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }
    }

    private static void printLottoNumbers(List<Lotto> lottos){
        lottos.forEach(lotto -> {
            System.out.println(lotto);
        });
    }
}
