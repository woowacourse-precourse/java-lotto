package lotto.view.converter;

import lotto.exception.ExceptionPhrase;
import lotto.view.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

public class ConvertPlayerNumbers implements Converter<String, List<Integer>> {

    private final LottoValidation lottoValidation;

    public ConvertPlayerNumbers() {
        lottoValidation = new LottoValidation();
    }
    public int toBonusNumber(String inputBonus) {
        lottoValidation.validateBonusNumber(inputBonus);
        return Integer.parseInt(inputBonus);
    }

    @Override
    public List<Integer> toNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();

        lottoValidation.validateInputIsInteger(input);

        String[] numbers = input.split(",");
        for(String number : numbers) {
            number = number.trim();
            int lottoNumber = Integer.parseInt(number);

            playerNumbers.add(lottoNumber);
        }
        return playerNumbers;
    }
}
