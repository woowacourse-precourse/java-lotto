package lotto.view;

import lotto.domain.Lotto;
import lotto.util.IOMessage;

public final class OutputView {
    private OutputView() {
    }

    public static void printIOMessage(String message) {
        System.out.println(message);
    }
//    public static void printLottos(Lottos lottos) {
//        // Lottos 클래스 구현 예정
//        // Lotto 객체가 요소인 Wrapper 클래스
//        // Lottos의 목적은 캡슐화가 아님. 단순히 정보 전달용 메세지.
//        // 따라서 상태에 접근해도 됨.
//        lottos.getLottos().stream()
//                .forEach(lotto -> System.out.println(lotto));
//    }
//
//    public static void printWinningRecord(Lotto userLotto) {
//        // 당첨 Enum은 몇개 일치, 몇원에 대한 정보를 가지고 있고
//        // 메소드를 통해 당첨 개수를 알아낼 수 있다. 메소드의 인자는 Lotto 객체.
//        // 리턴 값은 List로 줄 수도 있는데, 일급 컬렉션을 사용할까 고민임.
//
//        WinningLotto.makeNumberOfWins(userLotto).stream()
//                .forEach(prizeCount -> {
//                        WinningLotto.printPrizeInfo();
//                        System.out.println(prizeCount);
//                    }
//                );
//    }
}
