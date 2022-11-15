package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ui {

    private final LottoService lottoService = new LottoService();

    public void startLotto(){
        String purchaseAmount = inputPurchaseAmount();
        int lottoCount = lottoService.getLottoCount(purchaseAmount);
        lottoService.drawLottos(lottoCount);
        printLottoCountAndNumbers(lottoCount);
        String winNumber= inputWinNumber();
        String bonusNumber= inputBonusNumber();
        List<Integer> numbersOfWin = lottoService.findNumbersOfWin(winNumber, bonusNumber);
        double totalReturn = lottoService.getTotalReturn(purchaseAmount);
        printWinStatics(numbersOfWin,totalReturn);
    }

    private void printWinStatics(List<Integer> numbersOfWin,  double totalReturn){
        List<Integer> moneys = Stream.of(Money.values()).map(m -> m.getAmount()).filter(m->m!=1000).
                collect(Collectors.toList());
        System.out.println("당첨 통계\n" + "---");
        printWinCounts(numbersOfWin, moneys);
        System.out.println("총 수익률은 "+ totalReturn +"%입니다.");
    }

    private void printWinCounts(List<Integer> numbersOfWin, List<Integer> moneys) {
        for (int i = 0; i< moneys.size(); i++) {
            if(moneys.get(i)==Money.FIVE_THOUSAND.getAmount()){
                System.out.println("3개 일치 (5,000원) - "+ numbersOfWin.get(i)+"개");
            }if(moneys.get(i)==Money.FIFTY_THOUSAND.getAmount()){
                System.out.println("4개 일치 (50,000원) - "+ numbersOfWin.get(i)+"개");
            }if(moneys.get(i)==Money.ONE_MILLION_HALF.getAmount()){
                System.out.println("5개 일치 (1,500,000원) - "+ numbersOfWin.get(i)+"개");
            }if(moneys.get(i)==Money.THIRTY_MILLION.getAmount()){
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ numbersOfWin.get(i)+"개");
            }if(moneys.get(i)==Money.TWO_BILLION.getAmount()){
                System.out.println("6개 일치 (2,000,000,000원) - "+ numbersOfWin.get(i)+"개");
            }
        }
    }

    private String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        //당연히 validation 있어야 하고
        return readLine();
    }

    private String inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        //validation 있어야 하고
        return readLine();
    }

    private void printLottoCountAndNumbers(int lottoCount) {
        System.out.println(lottoCount +"개를 구매했습니다.");
        for (Lotto lotto : lottoService.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
         return readLine();
    }






}
