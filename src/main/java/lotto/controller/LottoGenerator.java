package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static List<Lotto> startLottoGenerate(String userMoney) {
        int cnt = calculateLottoCount(userMoney);
        return generateUserLottoNumbers(cnt);
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public static List<Lotto> generateUserLottoNumbers(int cnt) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int idx = 0; idx < cnt; idx++) {
            Lotto lotto = new Lotto(generateLottoNumber());
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    public static int calculateLottoCount(String userMoney) {
        return Integer.parseInt(userMoney)/1000;
    }

    public static List<Integer> splitTargetLotto(String targetInput) {
        List<String> targetNumber = Arrays.asList(targetInput.split(","));
        List<Integer> targetLotto = targetNumber.stream().map(Integer::parseInt).collect(Collectors.toList());

        return targetLotto;
    }
}
