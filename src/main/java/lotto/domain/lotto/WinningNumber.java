package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.rule.Rank;
import lotto.resource.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(String inputLottoNumbers, String inputBonusNumber) {
        List<String> splitLottoNumber = getSplitLottoNumber(inputLottoNumbers);
        validateNumberFormat(splitLottoNumber);
        Lotto lottoNumbers = new Lotto(
                splitLottoNumber.stream()
                        .map(LottoNumber::new)
                        .map(LottoNumber::getValueAsInt)
                        .collect(Collectors.toList())
        );

        validateNumberFormat(List.of(inputBonusNumber));
        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);

        validateDuplicateBonusNumberAndLottoNumbers(lottoNumbers, bonusNumber);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumberAndLottoNumbers(Lotto lottoNumbers,
                                                             LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER_AND_LOTTO_NUMBERS.getValue());
        }
    }

    private void validateNumberFormat(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            try {
                Integer.parseInt(lottoNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue()
                );
            }
        }
    }

    public Rank getRank(Lotto lotto) {
        int matchedCount = getMatchCount(lotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);

        return Rank.getRank(matchedCount, hasBonusNumber);
    }

    private int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto);
    }

    private List<String> getSplitLottoNumber(String lottoNumbers) {
        return Arrays.asList(lottoNumbers.split(",", -1));
    }
}
