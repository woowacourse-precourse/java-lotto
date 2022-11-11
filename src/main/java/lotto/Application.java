package lotto;

public class Application {
    public static final String WRONG_INPUT = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.run();
        }catch (IllegalArgumentException e){
            System.out.println(WRONG_INPUT);
        }
    }
}
