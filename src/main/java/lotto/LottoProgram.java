package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private final String ASK_FOR_ORDER_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String ORDER_QUANTITY_ALERT_MESSAGE = "%d개를 구매했습니다.\n";
    private final String ASK_FOR_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.";
    private final String ASK_FOR_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";
    
    private LottoController lottoController;

    public LottoProgram(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    // 로또 프로그램 실행
    public void run() {
        List<Lotto> userLottos = createUserLottos();
        alertUserLottos(userLottos);
        WinningLotto winningLotto = createWinningLotto();
    }

    private void alertUserLottos(List<Lotto> userLottos) {
        for (Lotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
    }

    public List<Lotto> createUserLottos() {
        int orderPrice = getOrderPrice();
        int orderQuantity = lottoController.getOrderQuantity(orderPrice);
        alertOrderQuantity(orderQuantity);

        return lottoController.createLottos(orderQuantity);
    }

    private void alertOrderQuantity(int orderQuantity) {
        System.out.printf(ORDER_QUANTITY_ALERT_MESSAGE, orderQuantity);
    }

    private int getOrderPrice() {
        System.out.println(ASK_FOR_ORDER_PRICE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public WinningLotto createWinningLotto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        return lottoController.createWinningLotto(lottoNumbers, getBonusNumber());
    }

    private List<Integer> getLottoNumbers() {
        System.out.println(ASK_FOR_LOTTO_NUMBERS_MESSAGE);
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] splittedNumbers = Console.readLine().split(",");
        for (String splittedNumber : splittedNumbers) {
            lottoNumbers.add(Integer.parseInt(splittedNumber));
        }

        return lottoNumbers;
    }

    private int getBonusNumber() {
        System.out.println(ASK_FOR_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
