package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final String DELIMITER = ",";
    private static final int ONE_LOTTO_PRICE = 1000;

    public static int getLottoCount(int lottoPrice) {
        return lottoPrice / ONE_LOTTO_PRICE;
    }

    public static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoCreator.createLotto());
        }

        return lottos;
    }

    public static List<Integer> spiltLottoNumber(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static WinningLotto createWinningLotto(String winningLottoNumber, String winningBonusNumber) {
        List<Integer> winningLotto = spiltLottoNumber(winningLottoNumber);
        int bonusNumber = Integer.parseInt(winningBonusNumber);

        return new WinningLotto(new Lotto(winningLotto), bonusNumber);
    }
}
