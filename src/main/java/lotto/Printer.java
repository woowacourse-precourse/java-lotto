package lotto;

import java.util.List;

public class Printer {

    private final int MONEY_UNIT=1000;
    public Printer(){

    }

    public void printHowManyLottos(int money){
        System.out.printf("%d개를 구매했습니다.%n", money/MONEY_UNIT);
    }

    public void printLottoNumbers(Lottos lottos){
        for(int order=0;order<lottos.size();order++){
            printEachLottoNumbers(lottos.get(order));
        }
    }

    private void printEachLottoNumbers(Lotto lotto) {
        List<Integer> list = new LottoNumberGenerater().makeLottoNumber(lotto);
        System.out.println(list);
    }

}
