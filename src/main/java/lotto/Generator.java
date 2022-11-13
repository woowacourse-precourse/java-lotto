package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    static final int STARTNUMBER = 1;
    static final int ENDNUMBER = 45;
    static final int COUNT = 6;

    public static List<Integer> creatNumber() {
        List<Integer> bundle = Randoms.pickUniqueNumbersInRange(STARTNUMBER, ENDNUMBER, COUNT);
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
