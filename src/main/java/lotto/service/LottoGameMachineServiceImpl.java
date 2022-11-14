package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;
import lotto.repository.LottoRepository;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoGameMachineServiceImpl implements LottoGameMachineService{

    private final LottoRepository repository = new LottoRepository();

    @Override
    public void enterMoney(int money) {
        repository.payMoney(money);
    }

    @Override
    public void enterTheWinningNumbers(Lotto winningNumbers) {
        repository.saveWinningNumbers(winningNumbers);
    }

    @Override
    public void enterBonusNumber(int bonusNumber) {
        repository.saveBonusNumber(bonusNumber);
    }

    @Override
    public LinkedHashMap<Rating, Integer> calculateStatistics() {
        return null;
    }

    @Override
    public int readLottoQuantity() {
        return repository.getLottoQuantity();
    }

    @Override
    public List<Lotto> readLottoNumbers() {
        return repository.getLottoNumbers();
    }

    @Override
    public int readMoney() {
        return repository.getMoney();
    }

    @Override
    public List<Integer> readWinningNumbers() {
        return repository.getWinningNumbers();
    }

    @Override
    public int readBonusNumber() {
        return repository.getBonusNumber();
    }
}
