package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoService(new UserLottoInfo()),
                new LottoConsole()); // -> to refactor! - 생성자 주입 방식 (설계도 역할하는 config 도입..?!)
        lottoController.executeGame();
    }
}
