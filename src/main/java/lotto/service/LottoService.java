package lotto.service;

import static lotto.domain.Lotto.END_LOTTO_NUMBER;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Lotto.START_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoService {

    List<Lotto> playerPurchaseLottos = new ArrayList<>();
    WinningLotto winningLotto;

    public void play() {
        setPlayerPurchaseLottos(purchaseLottos());
        setWinningLotto(inputWinningLotto());
    }

    private void setWinningLotto(WinningLotto inputWinningLotto) {
        winningLotto = inputWinningLotto;
    }

    WinningLotto inputWinningLotto() {
        Lotto lotto = getWinningLotto();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        List<Integer> winningLottoNumbers = inputWinningLottoNumbers();
        return new Lotto(winningLottoNumbers);
    }

    private List<Integer> inputWinningLottoNumbers() {
        String playerInput = Console.readLine();
        String[] inputNumbers = playerInput.split(",");
        try {
            return Arrays.stream(inputNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 반드시 숫자여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    private int inputBonusNumber() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 반드시 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    void setPlayerPurchaseLottos(List<Lotto> lottos) {
        playerPurchaseLottos.clear();
        playerPurchaseLottos.addAll(lottos);
    }

    List<Lotto> purchaseLottos() {
        int purchasePrice = inputPurchasePrice();
        if (purchasePrice % LOTTO_PRICE != 0) {
            System.out.printf("[ERROR] 로또는 %d원 단위로 나누어 떨어져야 합니다.\n", LOTTO_PRICE);
            throw new IllegalArgumentException();
        }
        return generateLottos(purchasePrice / LOTTO_PRICE);
    }

    int inputPurchasePrice() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 구매 금액은 반드시 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    Lotto generateLotto() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(uniqueNumbers);
    }
}
