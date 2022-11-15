package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRepository {
    private int money;
    private int lottoQuantity;
    private final List<Lotto> lottoNumbers = new ArrayList<>();
    private Lotto winningNumbers;
    private int bonusNumber;

    public void saveMoney(int money){
        this.money = money;
        calculateLottoQuantity();
        createLottoNumber();
    }

    public void saveWinningNumbers(Lotto winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void createLottoNumber() {
        for(int i=0;i<lottoQuantity;i++){
            this.lottoNumbers.add(new Lotto(generateLottoNumbers()));
        }
    }

    private void calculateLottoQuantity() {
        this.lottoQuantity = getMoney() / 1000;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }
}
