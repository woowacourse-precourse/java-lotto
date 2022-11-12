package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameConsole {

    private final Emcee emcee = new Emcee();
    private final Player player = new Player();
    private final LottoPublisher publisher = new LottoPublisher();
    private final Validator validator = new Validator();

    public void startLottoGame() {
        emcee.guideGame();
        int payment = handlePayment();
        // Lotto 발행
        // 당첨 lotto 생성
        // 당첨 결과 처리, 출력
    }

    private int handlePayment() {
        emcee.guideAmountOfPurchaseMoney();
        String paymentOfPurchase = player.paymentOfPurchase();
        validator.validatePayment(paymentOfPurchase);
        return Integer.parseInt(paymentOfPurchase);
    }

    private List<Lotto> publishLottos(int payment) {
        List<Lotto> lottos = publisher.publishLottos(payment);
        emcee.showPublishedLottos(lottos);
        return lottos;
    }

    private void createWinningLotto() {
        // 당첨 번호 생성
        // 보너스 번호 생성
        return; // 당첨 번호 + 보너스 번호
    }

    private List<Integer> createWinningNumbers() {
        emcee.guideWinningNumber();
        String winningNumbers = player.selectWinningNumbers();
        validator.validateWinningNumbers(winningNumbers);
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int createBonusNumber(List<Integer> winningNumbers) {
        // 보너스 번호 안내
        // 보너스 번호 입력
        // 보너스 번호 검증
        return 0;
    }

    private void handlePrizeOfLottoGame() {
        // 당첨 결과 처리
        // 당첨 결과 출력
    }
}
