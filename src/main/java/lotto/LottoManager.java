package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private InputManager inputManager;
    private List<Lotto> lottos;
    private LottoMachine lottoMachine;

    public LottoManager(){
        this.inputManager = new InputManager();
    }

    public void startLotto() {
        int amount = inputManager.getPurchasingAmount();
        int count = countBuyableLotto(amount);
        lottos = buyLotto(count);
        printLottoCount(count);
        printLottos(lottos);
        List<Integer> winningNumbers = inputManager.drawWinningNumbers();
        int bonusNumber = inputManager.drawBonusNumber();
        lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
    }

    public int countBuyableLotto(int amount) {
        int count;
        count = amount / 1000;
        
        return count;
    }

    public List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }
}
