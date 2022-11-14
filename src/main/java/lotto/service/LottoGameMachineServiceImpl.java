package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoGameMachineServiceImpl implements LottoGameMachineService{
    @Override
    public void enterMoney(int money) {

    }

    @Override
    public void enterTheWinningNumbers(Lotto winningNumbers) {

    }

    @Override
    public void enterBonusNumber(int bonusNumber) {

    }

    @Override
    public LinkedHashMap<Rating, Integer> calculateStatistics() {
        return null;
    }

    @Override
    public int readLottoQuantity() {
        return 0;
    }

    @Override
    public List<Lotto> readLottoNumbers() {
        return null;
    }

    @Override
    public int readMoney() {
        return 0;
    }

    @Override
    public List<Integer> readWinningNumbers() {
        return null;
    }

    @Override
    public int readBonusNumber() {
        return 0;
    }
}
