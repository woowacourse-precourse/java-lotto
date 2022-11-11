package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoResultService {
    public void getResult(List<Lotto> userLotto, String winningLottoInput, String bonusLottoInput) {
        WinningLotto winningLotto = createWinningLotto(winningLottoInput, bonusLottoInput);
    }

    private WinningLotto createWinningLotto(String winningLotto, String bonusLotto) {
        List<Integer> winningLottoResult = getWinningLotto(winningLotto);
        int bonusLottoResult = Integer.parseInt(bonusLotto);
        return getWinningLotto(winningLottoResult, bonusLottoResult);
    }

    private List<Integer> getWinningLotto(String winningLotto) {
        String[] userWinningLottoInput = winningLotto.split(",");
        return Arrays.stream(userWinningLottoInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private WinningLotto getWinningLotto(List<Integer> winningLottoResult, int bonusLottoResult) {
        return new WinningLotto(winningLottoResult, bonusLottoResult);
    }





}
