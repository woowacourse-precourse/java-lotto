package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInterface userInterface = new UserInterface();

        //사용자 구매금액 입력
        int purchasePrice = 0;
        try{
            purchasePrice = userInterface.getPurchasePrice();
        }catch(Exception e){
            return;
        }

        //로또머신 생성
        LottoMachine lottoMachine = new LottoMachine(purchasePrice);
        List<Lotto> purchasedLottos = lottoMachine.createLottos();
        userInterface.printLottos(purchasedLottos);
        Lotto winningNumber = new Lotto(userInterface.getWinningNumber());

        //당첨번호 확인
        Error.sizeWinningNumber(winningNumber.getNumbers());
        Error.duplicationWinningNumber(winningNumber.getNumbers());
        Error.rangeWinningNumber(winningNumber.getNumbers());

        //보너스 입력
        int bonus = userInterface.getBonusNumber();
        Error.containBonusInWinningNumber(winningNumber.getNumbers(),bonus);

        //랭크 및 수익률 출력
        userInterface.printResultRank(lottoMachine.analyzeRank(winningNumber,bonus,purchasedLottos));
        userInterface.printRateReturn(lottoMachine.calculateEarningRate());
    }
}
