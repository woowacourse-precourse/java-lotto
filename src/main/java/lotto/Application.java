package lotto;
import lotto.ui.LottoMachine;
public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        try {
            lottoMachine.start();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
