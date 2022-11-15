package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoConverter {
    public List<Integer> convertScanNumbersToWinningNumbers(List<String> lottoNumbers) {
        List<Integer> convertedNumbers = lottoNumbers.stream()
                .map(s -> Integer.parseInt(s.trim()))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return convertedNumbers;
    }

    public Lotto convertRandomNumbersToLotto(List<Integer> lottoNumbers) {
        List<Integer> convertedNumbers = lottoNumbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return new Lotto(convertedNumbers);
    }

    public Integer convertBonus(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public Long convertMoney(String playerMoney) {
        playerMoney = playerMoney.trim();
        if (playerMoney.contains(",")) {
            playerMoney = playerMoney.replace(",", "");
        }
        return Long.parseLong(playerMoney);
    }
}
