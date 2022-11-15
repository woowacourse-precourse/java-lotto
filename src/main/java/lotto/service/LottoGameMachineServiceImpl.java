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
        repository.saveMoney(money);
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
        LinkedHashMap<Rating, Integer> statistics = setUpTheOrderMap();
        for(Lotto lotto : repository.getLottoNumbers()){
            Rating rating = lottoMatches(lotto.getNumbers());
            if(rating.compareTo(Rating.NONE) == 0) continue;
            statistics.put(rating, statistics.getOrDefault(rating, 0) + 1);
        }
        return statistics;
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

    private LinkedHashMap<Rating, Integer> setUpTheOrderMap() {
        LinkedHashMap<Rating, Integer> map = new LinkedHashMap<>();
        for(Rating rating : Rating.values()){
            if(rating.compareTo(Rating.NONE) == 0) continue;
            map.put(rating, 0);
        }
        return map;
    }

    private Rating lottoMatches(List<Integer> numbers) {
        int matchCount = 0;
        boolean bonus = false;
        for(int number : numbers){
            if(repository.getWinningNumbers().contains(number)) matchCount ++;
            if(number == repository.getBonusNumber() && !bonus) bonus = true;
        }
        return Rating.checkTheRankings(matchCount, bonus);
    }
}
