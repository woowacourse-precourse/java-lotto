package lotto.view;

public class View {
    private static final String WELCOME_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String COUNT_MESSAGE = "개를 구매하였습니다.";
    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printLottoCountMessage(int count) {
        System.out.println(count + COUNT_MESSAGE);
    }
}
