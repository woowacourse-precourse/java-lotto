package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.WinningLotto;
import lotto.view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private static int price;
    private static int lottoNumber;
    private static final int oneLottoPrice = 1000;
    private static final int startRange = 1;
    private static final int endRange = 45;
    private static final int count = 6;

    private Printer printer = new Printer();

    public List<Lotto> generatePurchasedLottos(int lottoNumber){
        List<Lotto> purchasedLottos = new ArrayList<>();
        for(int number = 0; number < lottoNumber; number++){
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }
    public Lotto generateLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(startRange, endRange, count);
        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public int calculateLottoNumber(int price){
        if(price % oneLottoPrice != 0){
            throw new IllegalArgumentException("[ERROR] 가격은 천원 단위로 입력해주세요.");
        }
        return price / oneLottoPrice;
    }

    public int inputMoney(){
        printer.printInputMoney();
        String money = Console.readLine();
        if(!money.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해주세요.");
        }
        return Integer.parseInt(money);
    }

    public WinningLotto inputWinningLotto(){
        List<Integer> winningLottoNumbers = new ArrayList<>();
        printer.printInputWinningNumbers();
        inputWinningNumbers(winningLottoNumbers);
        printer.printInputWinningBonusNumber();
        inputBonusNumber(winningLottoNumbers);

        return new WinningLotto(winningLottoNumbers);
    }

    public void inputWinningNumbers(List<Integer> winningLotto){
        String inputWinnerNumbers = Console.readLine();
        String[] winningNumbers = inputWinnerNumbers.split(",");
        for (String winningNumber : winningNumbers) {
            winningLotto.add(Integer.parseInt(winningNumber));
        }
    }

    public void inputBonusNumber(List<Integer> winningLotto){
        String bonusNumber = Console.readLine();
        winningLotto.add(Integer.parseInt(bonusNumber));
    }

}
