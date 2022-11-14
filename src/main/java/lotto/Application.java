package lotto;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram();
        try {
            lottoProgram.play();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e);
        }
    }
}
