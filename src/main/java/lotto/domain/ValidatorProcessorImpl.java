package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatorProcessorImpl implements ValidatorProcessor{

    @Override
    public void validateMoney(Integer money, PriceEnum priceEnum) {
        if (money % priceEnum.getValue() != 0) {
            throw new IllegalArgumentException("금액 단위를 일치시켜야 합니다.");
        }
    }

    @Override
    public List<Integer> validateLottoNumberInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    @Override
    public void validateLottoSize(Integer size, LottoEnum lottoEnum) {
        if (size != lottoEnum.getSize()){
            throw new IllegalArgumentException("입력 길이가 다릅니다.");
        }
    }
}
