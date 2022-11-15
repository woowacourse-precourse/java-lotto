package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();

        lottoService.initLottoService();
        lottoService.matchLotto();
    }
}
