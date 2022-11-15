package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public int purchaseAmount, bonusNumber, totalProfit;
    public List<Integer> winningNumber, gameResult;
    public List<Lotto> issuedLotto;
    public double profitRate;
    public Input input;
    public Output output;

    public void play() {
        this.input = new Input();
        this.output = new Output();
        this.purchaseAmount = input.getPurchaseAmount(); // 로또 구매
        issueLotto(); // 로또 발행
        output.printIssuedLotto(issuedLotto); // 발행된 로또 출력
        this.winningNumber = input.getWinningNumber(); // 당첨 번호 입력
        this.bonusNumber = input.getBonusNumber(); // 보너스 번호 입력
        getGameResult(); // 로또 게임 결과 계산
        output.printGameResult(this.gameResult); // 로또 게임 결과 출력
        this.profitRate = getProfitRate(); // 수익률 게산
        output.printProfitRate(this.profitRate); // 수익률 출력
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Lotto> issueLotto() {
        this.issuedLotto = new ArrayList<Lotto>(purchaseAmount);

        for (int i=0; i<purchaseAmount; i++) {
            List<Integer> newLottoNumbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(newLottoNumbers); // 새 로또 생성
            issuedLotto.add(newLotto);
        }

        return issuedLotto; // 발행된 로또 리스트 반환
    }

    public void getGameResult() {
        this.gameResult = new ArrayList<Integer>(6); // i번째 원소에 i등에 당첨된 로또의 수를 저장하는 리스트

        for (int i=0; i<6; i++) {
            gameResult.add(0); // gameResult 리스트 원소를 0으로 초기화
        }
        for (int order=0; order < issuedLotto.size(); order++) {
            Lotto lotto = issuedLotto.get(order); // rank를 게산할 lotto
            Rank rank = lotto.calculateRank(winningNumber, bonusNumber); // 해당 lotto의 rank 계산

            if (rank != Rank.NO_PLACE) { // 5등 이상일 경우
                int place = rank.getPlace();
                gameResult.set(place, gameResult.get(place)+1); // i번째 원소(i등에 당첨된 로또 개수)를 +1
            }
        }
    }

    public int getTotalProfit() {
        this.totalProfit = 0;
        Rank rank = Rank.NO_PLACE; // 등수별 당첨금 확인에 사용할 Rank 객체 선언 및 초기화

        for (int place = 1; place < gameResult.size(); place++) { // gameResult에 저장된 1~5등 결과에 대해
            if (gameResult.get(place) > 0) { // 해당 등수에 대한 결과가 있을 경우
               this.totalProfit += rank.getProfit(place); // 해당 등수의 당첨금을 전체 수익금에 합산
            }
        }
        return totalProfit;
    }

    public double getProfitRate() {
        getTotalProfit();
        double profitRate = (double) totalProfit / (purchaseAmount*1000) * 100;

        return profitRate;
    }
}