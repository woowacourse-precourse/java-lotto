package lotto;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        DataProcessing dataProcessing = new DataProcessing();
        dataProcessing.splitLottoNumber(controller.inputLottoNumber());
    }
}
