package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoManager lottoManager = new LottoManager();
            lottoManager.runLotto();
        } catch (IllegalArgumentException exceptionMessage) {
            System.out.println(exceptionMessage.getMessage());
        } catch (Exception exceptionMessage) {
            System.out.println("[ERROR] 예기치 못한 예외가 발생하였습니다.");
        }
    }

}