package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoConverter {
    public List<Integer> convertScanNumbersToWinningNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(s -> Integer.parseInt(s.trim()))
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto convertRandomNumbersToLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream().sorted().collect(Collectors.toList()));
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
