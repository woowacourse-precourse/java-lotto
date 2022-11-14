package lotto;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = PurchaseLotto.purchaseLotto();
        if(lottos.isEmpty()){
            return;
        }
        List<Integer> drawNumber = InputLottoNumber.inputLottoAnswerNumber();
        if(drawNumber.isEmpty()){
            return;
        }
        int outcome = (lottos.size() * 1000);
        ResultCalculate.resultCalculate(lottos,drawNumber,outcome);
    }
}
