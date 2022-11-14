package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoConverter {
    public List<Integer> convertScanNumbersToWinningNumbers(List<String> lottoNumbers) {
        List<Integer> convertedNumbers = lottoNumbers.stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return convertedNumbers;
    }
    public Lotto convertRandomNumbersToLotto(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }

    public Integer convertBonus(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public Long convertMoney(String playerMoney) {
        playerMoney = playerMoney.trim();
        if(playerMoney.contains(",")){
            playerMoney = playerMoney.replace(",","");
        }
        return Long.parseLong(playerMoney) ;
    }
}
