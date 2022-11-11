package lotto.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int amountOfLotto) {
        settingLottos(amountOfLotto);
    }

    public static Lottos from(int amountOfLotto) {
        return new Lottos(amountOfLotto);
    }

    private void settingLottos(int amountOfLotto) {
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> tempLottoNumbers = new ArrayList<>();
            List<Integer> immutableLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            immutableToMutableNumbers(tempLottoNumbers, immutableLottoNumbers);

            Collections.sort(tempLottoNumbers);
            lottos.add(new Lotto(tempLottoNumbers));
        }
    }

    private void immutableToMutableNumbers(List<Integer> tempLottoNumbers,
        List<Integer> immutableLottoNumbers) {
        for (Integer immutableLottoNumber : immutableLottoNumbers) {
            tempLottoNumbers.add(immutableLottoNumber);
        }
    }

    public List<Lotto> currentLottos() {
        return lottos;
    }

    public void printWholeLottoNumbers() {
        lottos.stream().forEach(lotto -> lotto.printLottoNumbers());
    }
}
