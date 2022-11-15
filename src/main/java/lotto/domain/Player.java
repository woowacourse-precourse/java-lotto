package lotto.domain;

import static lotto.domain.Lotto.END_LOTTO_NUMBER;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Lotto.START_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Lotto> purchaseLottos = new ArrayList<>();
    int purchasePrice;

    private Player() {
    }

    public static Player purchase() {
        Player player = new Player();
        player.purchasePrice = inputPurchasePrice();
        if (player.purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("로또는 %d원 단위로 나누어 떨어져야 합니다.", LOTTO_PRICE));
        }
        player.purchaseLottos = generateLottos(player.purchasePrice / LOTTO_PRICE);
        return player;
    }

    static int inputPurchasePrice() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 구매 금액은 반드시 숫자여야 합니다.", e);
        }
    }

    static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    static Lotto generateLotto() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(uniqueNumbers);
    }

    public List<Lotto> getPurchaseLottos() {
        return new ArrayList<>(purchaseLottos);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
