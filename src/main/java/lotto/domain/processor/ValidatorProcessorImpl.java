package lotto.domain.processor;

import lotto.domain.enummodel.ErrorMessageEnum;
import lotto.domain.enummodel.LottoEnum;
import lotto.domain.enummodel.PriceEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatorProcessorImpl implements ValidatorProcessor{

    @Override
    public void validateMoney(Integer money, PriceEnum priceEnum) {
        if (money % priceEnum.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_MESSAGE_NOT_MATCH.getValue());
        }
    }

    @Override
    public List<Integer> validateAndParseLottoNumberInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_MESSAGE_VALIDATE.getValue());
        }
    }

    @Override
    public void validateLottoSize(Integer size, LottoEnum lottoEnum) {
        if (size != lottoEnum.getSize()){
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_MESSAGE_INPUT_SIZE.getValue());
        }
    }

    @Override
    public void validateLottoNumber(List<Integer> number, LottoEnum lottoEnum) {
        List<Integer> validatedNumber = number.stream()
                .filter(i -> lottoEnum.getMinNum()<= i)
                .filter(i -> i <= lottoEnum.getMaxNum())
                .collect(Collectors.toList());
        if (validatedNumber.size() != lottoEnum.getSize()) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_MESSAGE_NUMBER_RANGE.getValue());
        }
    }
}
