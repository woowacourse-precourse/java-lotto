package lotto.converter;

import lotto.exception.ExceptionPhrase;
import lotto.validation.PlayerNumberValidation;

import java.util.ArrayList;
import java.util.List;

public class ConvertPlayerNumbers implements Converter<String, List<Integer>> {

    private final PlayerNumberValidation playerNumberValidation;

    public ConvertPlayerNumbers() {
        playerNumberValidation = new PlayerNumberValidation();
    }

    @Override
    public List<Integer> toNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();

        if(!playerNumberValidation.validateInputIsInteger(input)) {
            throw new IllegalArgumentException(ExceptionPhrase.EXCEPTION_INVALID_INPUT.getMessage());
        }

        String[] numbers = input.split(",");
        for(String number : numbers) {
            number = number.trim();
            int lottoNumber = Integer.parseInt(number);

            playerNumbers.add(lottoNumber);
        }
        return playerNumbers;
    }
}
