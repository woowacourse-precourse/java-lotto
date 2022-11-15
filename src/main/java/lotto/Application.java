package lotto;

public class Application {
    private static String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        LottoPlay lottoPlay = new LottoPlay();
        try{
            lottoPlay.play();
        } catch (IllegalStateException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}
