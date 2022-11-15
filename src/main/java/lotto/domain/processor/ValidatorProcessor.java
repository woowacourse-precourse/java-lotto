package lotto.domain.processor;

import lotto.domain.enummodel.LottoEnum;
import lotto.domain.enummodel.PriceEnum;

import java.util.List;

public interface ValidatorProcessor {

    /**
     * 입력금액과 현재 로또가격을 입력받아서 유효성을 검증한다.
     * @param money - 입력금액
     * @param priceEnum - 현재 로또가격이 담긴 enum
     */
    void validateMoney(Integer money, PriceEnum priceEnum);

    /**
     * 입력값이 숫자인지 확인하고 반환한다.
     * @param input - 입력 String
     * @return - 입력값의 숫자
     */
    List<Integer> validateAndParseLottoNumberInput(String input);

    /**
     * 로또 배열의 사이즈를 검증한다.
     * @param size - 검증대상 사이즈
     * @param lottoEnum - 기준 사이즈가 담긴 enum
     */
    void validateLottoSize(Integer size, LottoEnum lottoEnum);

    /**
     * 로또 숫자의 범위가 유요한지 확인한다.
     * @param number - 로또배열
     * @param lottoEnum - 범위가 담긴 enum
     */
    void validateLottoNumber(List<Integer> number, LottoEnum lottoEnum);
}
