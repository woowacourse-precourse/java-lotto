package lotto.model.computer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import lotto.model.resources.Lotto;

import lotto.model.computer.lottonumber.LottoLine;
import lotto.model.computer.repository.LottoRepository;

import lotto.model.resources.Money;
import lotto.model.resources.Rank;

public class LottoComputer {

    private static final int CURRENCY = 1000;
    private static final int ALL_RANKS = 5;
    private static final int LOTTO_SIZE = 6;
    private static final int INITIALIZE_ZERO = 0;
    private static final boolean INITIALIZE_FALSE = false;

    LottoRepository lottoRepository;
    Money money;

    public LottoComputer() {
        this.lottoRepository = new LottoRepository();
    }

    public void buyLotto(Money money) {
        LottoLine lottoLine;
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();

        this.money = money;
        for (long i = 0; i < money.moneyDivide1000(); i++) {
            lottoLine = new LottoLine(sortLotto(createLottoNumber(lottoRandomGenerator)));
            lottoRepository.saveLotto(lottoLine);
        }
    }

    public long howManyLotto() {
        return lottoRepository.sizeOfLotto();
    }

    public Map<Integer, Integer> lottoCount(List<Integer> lotto, int bonusLotto) {
        Map<Integer, Integer> lottoResult = initializeLotto(new HashMap<>());
        AtomicInteger countWin = new AtomicInteger();
        AtomicBoolean bonus = new AtomicBoolean(INITIALIZE_FALSE);
        lottoRepository.repositoryForEach((oneLotto) -> {
            oneLotto.lottoNumberForEach((lottoNumber) -> {
                checkCount(lotto, countWin, lottoNumber);
                checkBonus(bonusLotto, bonus, lottoNumber);
            });
            Rank.addWinners(lottoResult, countWin, bonus);
            countWin.set(INITIALIZE_ZERO);
            bonus.set(INITIALIZE_FALSE);
        });
        return lottoResult;
    }

    private static void checkCount(List<Integer> lotto, AtomicInteger countWin, Integer lottoNumber) {
        for (Integer num : lotto) {
            if (lottoNumber.equals(num)) {
                countWin.getAndIncrement();
            }
        }
    }

    private static void checkBonus(int bonusLotto, AtomicBoolean bonus, Integer lottoNumber) {
        if (lottoNumber.equals(bonusLotto)) {
            bonus.set(true);
        }
    }

    public long getMoney() {
        return money.moneyDivide1000() * CURRENCY;
    }

    private Map<Integer, Integer> initializeLotto(Map<Integer, Integer> lottoResult) {
        for (int i = 0; i < ALL_RANKS; i++) {
            lottoResult.put(i, INITIALIZE_ZERO);
        }
        return lottoResult;
    }

    private List<Integer> createLottoNumber(LottoRandomGenerator lottoRandomGenerator) {
        Lotto lotto = lottoRandomGenerator.generateNumber(LOTTO_SIZE);
        return lotto.getNumbers();
    }

    private List<Integer> sortLotto(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }

    public String allLottoLines() {
        return lottoRepository.toString();
    }
}
