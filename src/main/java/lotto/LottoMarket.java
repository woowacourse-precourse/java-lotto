package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMarket {
    private static final int LOTTOPRICE = 1000;
    private int purchasePrice;
    private int purchaseLottoNum;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoMarket() {
        inputPrice();
        publishLotto();
        printLottoInfo();
    }

    private void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String s = Console.readLine();

        validateInputPrice(s);

        this.purchasePrice = Integer.parseInt(s);
        this.purchaseLottoNum = purchasePrice / LOTTOPRICE;
    }

    public void validateInputPrice(String s) {
        // 숫자가 아닌 문자가 입력되었을 때
        char[] arrCh = s.toCharArray();
        for (char ch : arrCh) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException();
        }

        // 금액이 1000으로 나뉘어 떨어지지 않는 경우
        int price = Integer.parseInt(s);
        if (price % LOTTOPRICE != 0)
            throw new IllegalArgumentException();
    }

    private void publishLotto() {
        for (int i = 0; i < purchaseLottoNum; i++) {
            NumberGenerator numberGenerator = new NumberGenerator();
            Lotto lotto = new Lotto(numberGenerator.getNumbers());
            lottos.add(lotto);
        }
    }

    private void printLottoInfo() {
        System.out.println(purchaseLottoNum + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
