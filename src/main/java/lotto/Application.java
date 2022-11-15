package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ScreenPrinter screenPrinter = new ScreenPrinter();
        LottoManager lottoManager = new LottoManager(screenPrinter);
        lottoManager.playLotto();
    }
}
