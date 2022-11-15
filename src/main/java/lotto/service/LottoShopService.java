package lotto.service;

import lotto.dto.WinningLottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShopService {

    private final LottoNumberFormValidation lottoNumberFormValidation = new LottoNumberFormValidation();

    public WinningLottoNumber getWinningLottoNumber(String writeLottoNumber, String writeBonusNumber) {
        lottoNumberFormValidation.blankIncludeValid(writeLottoNumber, writeBonusNumber);

        List<Integer> winningNumbers = getSplitSeparator(writeLottoNumber);
        int bonusNumber = lottoNumberFormValidation.getValidBonusNumber(writeBonusNumber);

        return WinningLottoNumber.createWinningLottoNumber(winningNumbers, bonusNumber);
    }

    private List<Integer> getSplitSeparator(String writeLottoNumber) {
        return Arrays.stream(writeLottoNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
