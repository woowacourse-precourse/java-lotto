package lotto.service;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    public static final int LOTTO_PRICE = 1000;
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;

    final List<Lotto> playerPurchaseLottos = new ArrayList<>();

    public void play() {
        setPlayerPurchaseLottos(purchaseLottos());
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
