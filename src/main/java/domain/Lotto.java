package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import util.LottoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.LottoUtils.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    public static List<Lotto> generateLottos(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public static Lotto generateWinningLotto() {
        List<Integer> winningNumbers = LottoUtils.getWinningNumbers();
        return new Lotto(winningNumbers);
    }

    public static int generateBonusNumber(){
        int bonusNumber = LottoUtils.getBonusNumber();
        validate(bonusNumber);

        return bonusNumber;
    }
}

