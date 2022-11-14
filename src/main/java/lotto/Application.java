package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        try {
            String inputMoney = Console.readLine();
            BuyLotto buyLotto = new BuyLotto(inputMoney);
            buyLotto.buyLottoprint();
            int numberOflottos = buyLotto.buyLotto();
            RandomLottos makeLottos = new RandomLottos(numberOflottos);
            makeLottos.printLottoNumbers();
            calculateLotto calculateLotto = new calculateLotto();
            List<Integer> list = calculateLotto.winLotto(makeLottos.getLottosNumber());

            double l = calculateLotto.rateLotto(numberOflottos,list);
            calculateLotto.printWinLotto(list,l);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]"+e.getMessage());
        }

    }
}