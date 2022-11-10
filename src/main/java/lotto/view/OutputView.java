package lotto.view;

public final class OutputView {
    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        // Lottos 클래스 구현 예정
        // Lotto 객체가 요소인 Wrapper 클래스
        // Lottos의 목적은 캡슐화가 아님. 단순히 정보 전달용 메세지.
        // 따라서 상태에 접근해도 됨.
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto));
    }
}
