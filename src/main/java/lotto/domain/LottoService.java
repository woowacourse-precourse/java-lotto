package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public int getLottoAmount(String number) {
        int balance = 0;

        try {
            balance = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("구입금액으로 입력된 문자열이 올바르지 않습니다.");
        }

        if (balance % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위이어야 합니다.");
        }

        return balance / 1000;
    }

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> lottoResult = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers = new ArrayList<>(lottoNumbers);
            lottoNumbers.sort(Integer::compareTo);

            lottoResult.add(new Lotto(lottoNumbers));
        }

        return lottoResult;
    }
}
