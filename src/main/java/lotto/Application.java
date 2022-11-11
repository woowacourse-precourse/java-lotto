package lotto;

import lotto.service.MatchLogic;
import lotto.view.LottoIO;
import lotto.view.UserIO;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 객체, 변수 생성
        LottoIO lottoInfo = new LottoIO();
        UserIO user = new UserIO();
        int budget;
        int amount;
        double yields;

        // 구입금액 입력
        budget = user.moneySpent();

        // 구매 갯수와 번호 출력
        amount = user.purchasedAmount(budget);
        user.purchaseLotto(amount);
        user.printLotto();

        // 당첨 번호와 보너스 번호 입력
        lottoInfo.inputLottoAnswer();
        lottoInfo.inputBonusAnswer();

        // 핵심 로직: 번호 비교, 수익률 계산
        MatchLogic matcher = new MatchLogic(lottoInfo, user);
        matcher.countMatches();
        yields = matcher.computeYields(budget);

        // 당첨 통계 결과 출력
        lottoInfo.printResult(matcher.getMatchNums(), yields);
    }
}
