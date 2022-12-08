package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoMachine {
    private WinningLottoNumber winningLottoNumber;

    public LottoMachine(WinningLottoNumber winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }

    public WinningLotto isWinningLotto(Lotto lotto) {
        Integer winningNumberCount = getWinningNumberCount(lotto);
        List<Integer> lottoNumbers = lotto.getNumbers();
        int bonusNumber = winningLottoNumber.getBonusNumber();
        return WinningLotto.from(winningNumberCount, lottoNumbers.contains(bonusNumber));
    }

    private Integer getWinningNumberCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.stream().filter(number -> this.winningLottoNumber.getWinningNumber().stream()
                .anyMatch(Predicate.isEqual(number))).collect(Collectors.toList()).size();
    }

    public WinningLottoTicket createLottoTicket(LottoList lottoList) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket();
        lottoList.getLottoList().stream()
                .map(this::isWinningLotto)
                .forEach(winningLottoTicket::countWinningLotto);

        return winningLottoTicket;
    }
}
