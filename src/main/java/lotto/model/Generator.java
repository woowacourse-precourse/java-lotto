package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    static final int COUNT = 6;

    public static List<Integer> creatNumber() {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
        List<Integer> bundle = new ArrayList<>(temp);
        Collections.sort(bundle);
        return bundle;
    }

    public static List<Lotto> creatLottoBundle(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Generator.creatNumber()));
        }
        return lottos;
    }

    public static List<Integer> creatWinningNumber(String input) {
        int[] winningNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumber.add(winningNumbers[i]);
        }
        return winningNumber;
    }

    public static List<Integer> addBonusNumber(List<Integer> winingNumber, int bonusNumber) {
        winingNumber.add(bonusNumber);
        Collections.sort(winingNumber);
        return winingNumber;
    }
}
