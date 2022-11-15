package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> lottoPaper = new ArrayList<>();

    public void viewLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void createLottoNumbers() {
        Lotto lotto = new Lotto(createRandomNumbers());
        saveLottoNumbers(lotto);
    }

    public void buyLotto(int buyNumber) {
        for (int i = 0; i < buyNumber; i++) {
            createLottoNumbers();
            viewLottoNumbers(LottoMachine.lottoPaper.get(i));
        }
    }

    public int calculateBuyNumber(int playerMoney) {
        int buyNumber = playerMoney / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", buyNumber);
        return buyNumber;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        return lotto;
    }

    private void saveLottoNumbers(Lotto lotto) {
        lottoPaper.add(lotto);
    }
}
