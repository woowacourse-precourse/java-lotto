package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RaffleNumber {
    private static final String COMMA=",";
    private static final int ZERO_BONUS=0;
    private List<Integer> raffleNumbers = new ArrayList<>();
    private int bonusNumber;

    public RaffleNumber(String raffleNumber, String bonusNumber) {
        this.bonusNumber = ZERO_BONUS;
        validateRaffleNumber(raffleNumber);
        validateBonusNumber(bonusNumber);
    }

    public void validateRaffleNumber(String raffleNumber) {

        Validation.validateProperRaffleNumber(raffleNumber);
        List<String> separatedRaffleNumber = separateRaffleNumberByComma(raffleNumber);
        List<Integer> transformedRaffleNumber=transform(separatedRaffleNumber, Integer::parseInt);
        Validation.validateProperQuantity(transformedRaffleNumber);
        Validation.validateDuplicatedNumbers(transformedRaffleNumber);
        this.raffleNumbers = transformedRaffleNumber;
    }

    public void validateBonusNumber(String bonusNumber) {
        Validation.validateProperBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getRaffleNumbers() {
        return raffleNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<String> separateRaffleNumberByComma(String raffleNumber) {
        return List.of(raffleNumber.split(COMMA));
    }

    private <T, U> List<U> transform(List<T> list, Function<T, U> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

}