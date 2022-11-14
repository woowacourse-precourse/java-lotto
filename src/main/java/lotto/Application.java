package lotto;

public class Application {
    public static void main(String[] args) {
        IOManage io = new IOManage();

        io.inputPayment();
        io.outputLottoGeneration();
        io.inputWinningNumbers();
        io.inputBonusNumber();
        io.outputStatistic();
        io.outputEarningRate();
        // TODO: 프로그램 구현
    }
}
