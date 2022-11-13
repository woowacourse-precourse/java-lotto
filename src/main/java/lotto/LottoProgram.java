package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private final String ORDER_QUANTITY_ALERT_MESSAGE = "%d개를 구매했습니다.\n";
    
    private LottoController lottoController;

    public LottoProgram(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    // 로또 프로그램 실행
    public void run() {
        List<Lotto> userLottos = createUserLottos();
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
        return Integer.parseInt(Console.readLine());
    }

    public WinningLotto createWinningLotto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        return lottoController.createWinningLotto(lottoNumbers, getBonusNumber());
    }

    private List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] splittedNumbers = Console.readLine().split(",");
        for (String splittedNumber : splittedNumbers) {
            lottoNumbers.add(Integer.parseInt(splittedNumber));
        }

        return lottoNumbers;
    }

    private int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
