package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        try {
            lottoController.lottoPlay();
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
