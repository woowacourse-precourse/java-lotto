package lotto;

import java.util.List;

public class Emcee {

    public void guideGame() {
        String startingGuide = "Lotto game 에 오신 것을 환영합니다.\n" +
                "원하시는 만큼의 lotto 를 구매할 수 있으며 lotto 는 자동 발행됩니다.\n" +
                "당첨 번호와 보너스 번호를 생성하면 발행된 lotto 들의 당첨 여부를 계산합니다.\n" +
                "최종적으로 당첨 통계와 수익률을 알려드립니다.\n" +
                "게임을 시작하겠습니다.";
        System.out.println(startingGuide);
    }

    public void guideAmountOfPurchaseMoney() {
        String guide = "구입 금액을 입력해주세요.\n" +
                "구입 금액은 1,000원 단위로 입력이 가능합니다.";
        System.out.println(guide);
    }

    public void showPublishedLottos(List<Lotto> lottos) {

    }

    public void guideWinningNumber() {

    }

    public void guideBonusNumber() {

    }

    public void showResultOfLottoGame() {

    }

    private void showStatistics() {

    }

    private void showYield() {

    }
}
