package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
        static String lottoinputMessage = "로또번호 입력하세요.";
        static String bonusinputMessage = "보너스번호 입력하세요.";
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
            try {
                    String inputMoney = Console.readLine();
                    BuyLotto buyLotto = new BuyLotto(inputMoney);
                    buyLotto.buyLottoprint();
                    int numberOflottos = buyLotto.buyLotto();
                    RandomLottos makeLottos = new RandomLottos(numberOflottos);
                    makeLottos.printLottoNumbers();
                    System.out.println(lottoinputMessage);
                    String inputLotto = Console.readLine();
                    System.out.println(bonusinputMessage);
                    String bonusLotto = Console.readLine();
                    WinLotto calculateLotto = new WinLotto(inputLotto,bonusLotto);
                    List<Integer> list = calculateLotto.winLotto(makeLottos.getLottosNumber());

                    double l = calculateLotto.rateLotto(numberOflottos,list);
                    calculateLotto.printWinLotto(list,l);

            }catch (IllegalArgumentException e){
                    System.out.println("[ERROR]"+e.getMessage());
            }

//

    }
}