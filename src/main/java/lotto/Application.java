package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            LottoController lottoController = new LottoController();
            lottoController.run();
        }catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }
}
