package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoView {
    private final LottoController lottoController;

    public LottoView() {
        this.lottoController = new LottoController();
    }

    public void startLottoApplication(){
        try{
            inputPurchaseAmount();
            inputWinningNumbers();
            inputBonusNumber();
            printWinningStats();
        } catch (RuntimeException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        System.out.println();
        List<Lotto> lottos = lottoController.purchaseLotto(inputAmount);
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private void inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        System.out.println();
        lottoController.setWinningNumbers(inputWinningNumber);
    }

    private void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        System.out.println();
        lottoController.setBonusNumber(inputBonusNumber);
    }

    private void printWinningStats(){
        System.out.println("당첨 통계");
        System.out.println("---");
        printResultsStats();
        printYieldStats();
    }

    private void printResultsStats(){
        List<Integer> lottoRankResults = lottoController.getLottoRankResults();
        for (int index = 0; index < lottoRankResults.size(); index ++){
            String hitsCountMessage = LottoRank.values()[index].getHitsCountMessage();
            int count = lottoRankResults.get(index);
            System.out.println(hitsCountMessage + " - " + count + "개");
        }
    }

    private void printYieldStats(){
        double yield = lottoController.getLottoYield();
        String yieldText = String.format("%.1f",yield);
        System.out.println("총 수익률은 " + yieldText + "%입니다.");
    }
}
