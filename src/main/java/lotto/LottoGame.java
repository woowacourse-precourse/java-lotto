package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void startGame(){

        User user = new User();

        System.out.println("로또를 구매할 금액을 입력해주세요.(1,000의 배수만 가능합니다.)");
        user.lottoPurchaseAmount(new UserInputGeneratorImpl());

        int lottoAmount = user.getPurchaseAmount();
        System.out.println(lottoAmount + "개를 구매했습니다.");
        List<List<Integer>> winningNumbers = makeLottoWinningNumbers(lottoAmount);
        printWinningLottoNumber(winningNumbers);

        System.out.println("번호 여섯 자리를 입력해 주세요.(쉼표로 구분합니다.)");
        List<Integer> userNumber = user.userLottoNumbers(new UserInputGeneratorImpl());

        System.out.println("보너스 번호를 입력해주세요.(1~45만 가능합니다.)");
        int bonusNumber = user.isNumberAndInRange(user.userInput(new UserInputGeneratorImpl()));

        System.out.println("당첨 통계\n" + "---");
        confirmWinningCount(winningNumbers, userNumber, bonusNumber);
        printEarnRate(lottoAmount);
    }

    private void printEarnRate(int amount){
        long total = printResultAnGetTotal();
        double earnRate = (double) total/(amount*LottoValues.LOTTO_AMOUNT.getValue());

        System.out.println(String.format("총 수익률은 %1$,.1f", earnRate) + "%입니다.");
    }

    private long printResultAnGetTotal(){
        long total = 0L;

        for (Winning win : Winning.values()) {
            if(win == Winning.NOTHING) continue;
            System.out.println(win.getWinningMessage() + win.getCount() + "개");
            total += ((long)win.getCount() * win.getValue());
        }
        return  total;
    }

    public void confirmWinningCount(List<List<Integer>> winningNumbers,
                                             List<Integer> userNumber,
                                             int bonusNumber){
        for (List<Integer> winningNumber : winningNumbers) {
            int count = compareWinningAndUserInput(winningNumber, userNumber, bonusNumber);

            Winning.findWinningValue(count, winningNumber, bonusNumber);
        }
    }

    private int compareWinningAndUserInput(List<Integer> winningNumber,
                                           List<Integer> userNumber,
                                           int bonusNumber) {
        int count = 0;
        for (int user : userNumber) {
            if(winningNumber.contains(user)) count++;
        }

        if(!userNumber.contains(bonusNumber)
                && winningNumber.contains(bonusNumber)) count++;

        return count;
    }

    public List<List<Integer>> makeLottoWinningNumbers(int lottoAmount) {
        List<List<Integer>> amount = new ArrayList<>();
        for(int i=0; i<lottoAmount; i++){
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(1, 45, 6);
            amount.add(numbers);
        }
        return amount;
    }

    private void printWinningLottoNumber(List<List<Integer>> winningNumbers){
        for (List<Integer> winningNumber : winningNumbers) {
            System.out.println(winningNumber.toString());
        }
    }
}
