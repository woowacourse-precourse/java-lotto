package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.setting.Setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

    private final List<List<Integer>> lottos;

    // 구입한 로또 수 만큼 로또 생성
    public LottoStore(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Setting.LOTTO_MIN_NUMBER, Setting.LOTTO_MAX_NUMBER, Setting.LOTTO_SIZE);
            lotto = lotto.stream().sorted().collect(Collectors.toList());
            lottoList.add(lotto);
        }
        this.lottos = lottoList;
    }

    // 구입한 로또 반환
    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
