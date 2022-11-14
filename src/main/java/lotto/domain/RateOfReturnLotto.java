package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RateOfReturnLotto {

    private CountLottoNumber countLottoNumber;
    private int purchaseAmount;
    private int totalWinnigAmount;
    private List<Integer> winningList;
    private List<Integer> winningAmountList;
    private double totalRatePercent;

    public RateOfReturnLotto() throws IllegalArgumentException {
        this.countLottoNumber = new CountLottoNumber();
        this.purchaseAmount = countLottoNumber.getPurchaseAmount();
        this.totalRatePercent = 0;
        this.winningAmountList = new ArrayList<>();
    }

    // 당첨번호 생성
    public void winningLottoNumber() throws IllegalArgumentException{
        countLottoNumber.winningLottoNumber();
    }

    // 보너스번호 생성
    public void bonusLottoNumber() {
        countLottoNumber.bonusLottoNumber();
    }

    // 로또구매횟수 get
    public int getPurchaseCount() {
        return countLottoNumber.getPurchaseCount();
    }

    // 로또리스트들 get
    public List<List<Integer>> getRandomLists() {
        return countLottoNumber.getRandomLists();
    }

    // 당첨 결과 리스트 출력
    public List<Integer> winningLottoResult() {
        this.winningList = countLottoNumber.correctCountCal();
        return winningList;
    }

    // 총 수익률 계산
    public double totalRatePercentCal() {
        setTotalWinnigAmount();
        this.totalRatePercent = (double) totalWinnigAmount / (double) purchaseAmount * 100;
        return totalRatePercent;
    }

    // 당첨 총 금액 저장
    private void setTotalWinnigAmount() {
        setWinningAmount();
        for(int i = 0; i < winningList.size(); i++) {
            this.totalWinnigAmount += winningAmountList.get(i) * winningList.get(i);
        }
    }

    // 당첨금액 저장
    public void setWinningAmount(){
        for(CorrectState state : CorrectState.values()) {
            if(state == CorrectState.NOTHING) break;
            this.winningAmountList.add(state.getAmount());
        }
    }

}
