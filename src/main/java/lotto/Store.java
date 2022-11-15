package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static final int lottoPrice = 1000;
    private Lotto winningLotto;
    private Integer bonusNumber;

    public List<Lotto> sellLotto(int money) {
        validateInputMoney(money);
        int count = money / 1000;

        // 로또 발행
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = issueLotto();
            lottos.add(lotto);
        }

        // 출력
        printLottoInform(lottos);
        return lottos;
    }

    private void validateInputMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000의 배수만 입력되야합니다.");
        }
    }

    // 로또를 발행한다.
    private Lotto issueLotto() {
        List<Integer> numbers = Lotto.generateRandomNumbers();
        return new Lotto(numbers);
    }

    private void printLottoInform(List<Lotto> lottos) {
        // 발행한 로또 개수 출력
        int count_lotto = lottos.size();
        System.out.println(count_lotto + "개를 구매했습니다.");

        // 발행한 로또들에 번호 출력
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public LottoResult checkPrize(List<Lotto> lottos) {
        validateWinningLotto();
        validateBonusNumber();

        LottoResult lottoResult = new LottoResult();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int count = countMatchingNumbers(numbers, winningNumbers);
            boolean bonus = hasBonusNumber(numbers, bonusNumber);
            Prize prize = Prize.valueOf(count, bonus);
            lottoResult.addPrize(prize);
        }

        return lottoResult;
    }

    private void validateWinningLotto() {
        if (winningLotto == null) {
            throw new NullPointerException("[ERROR] 1등번호가 존재하지 않습니다.");
        }
    }

    private void validateBonusNumber() {
        if (bonusNumber == null) {
            throw new NullPointerException("[ERROR] 보너스 번호가 존재하지 않습니다.");
        }
        if (winningLotto != null) {  // 1등 당첨번호와 보너스번호가 중복되면 예외 발생
            List<Integer> winningNumbers = winningLotto.getNumbers();
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
    }

    // 보너스 넘버가 있는 경우 true를 반환
    private boolean hasBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // 당첨번호와 일치하는 숫자가 몇 개인지 확인
    private int countMatchingNumbers(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void setGameNumbers(Lotto winningLotto, int bonusNumber) {
        setWinningLotto(winningLotto);
        setBonusNumber(bonusNumber);
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        validateWinningLotto();
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }
}