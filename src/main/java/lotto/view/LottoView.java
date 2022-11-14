package lotto.view;

import lotto.domain.CorrectState;
import lotto.domain.RateOfReturnLotto;

import java.util.ArrayList;
import java.util.List;

import lotto.message.ProgressLottoMessage;

public class LottoView {
    private RateOfReturnLotto rateOfReturnLotto;
    private int purchaseCount;
    private double totalRatePercent;
    private List<List<Integer>> listOfListLotto;
    private List<Integer> winningList;

    public LottoView() throws IllegalArgumentException {
        lottoAmountMessage();
        this.rateOfReturnLotto = new RateOfReturnLotto();
        this.winningList = new ArrayList<>();
        this.totalRatePercent = 0;
    }

    // 로또금액 출력요구 메시지
    public void lottoAmountMessage() {
        System.out.println(ProgressLottoMessage.LOTTO_AMOUNT_MESSAGE);
    }

    // 구매금액과 로또리스트들 저장
    public void lottoSetView() {
        this.purchaseCount = rateOfReturnLotto.getPurchaseCount();
        this.listOfListLotto = rateOfReturnLotto.getRandomLists();
        printLottoNumber();
    }

    // 당첨번호 입력 요구 메시지
    public void lottoNumberMessage() throws IllegalArgumentException{
        System.out.println();
        System.out.println(ProgressLottoMessage.WINNING_NUMBER_MESSAGE);
        rateOfReturnLotto.winningLottoNumber();
    }

    // 로또리스트 전체 출력
    public void printLottoNumber() {
        System.out.println();
        System.out.println(String.format(ProgressLottoMessage.PURCHASE_MESSAGE,purchaseCount));
        for(List<Integer> list : listOfListLotto) {
            System.out.println(list);
        }
    }

    // 보너스 번호 입력 요구 메시지
    public void printLottoBonus() {
        System.out.println();
        System.out.println(ProgressLottoMessage.BONUS_NUMBER_MESSAGE);
        rateOfReturnLotto.bonusLottoNumber();
    }

    // 당첨 통계 결과 메시지 출력
    public void lottoWinningMessage() {
        System.out.println();
        System.out.println(ProgressLottoMessage.LOTTO_STATISTICS_MESSAGE);
        System.out.println(ProgressLottoMessage.LINE_MESSAGE);
        winningList = rateOfReturnLotto.winningLottoResult();
    }

    // 당첨 통계 결과 출력
    public void lottoWinningResult() {
        int i = 0;
        for(CorrectState state : CorrectState.values()) {
            if(state == CorrectState.NOTHING) break;
            if(state == CorrectState.FIVE_AND_BONUS_CORRECT) {
                System.out.println(String.format(ProgressLottoMessage.CORRECT_BONUS_MESSAGE,winningList.get(i)));
                i += 1;
                continue;
            }
            System.out.println(String.format(ProgressLottoMessage.CORRECT_MESSAGE,
                    state.getMatchNumber(),state.getAmount(),winningList.get(i)));
            i += 1;
        }
    }

    // 총 수익률 결과 출력
    public void rateOfReturnResult() {
        this.totalRatePercent = rateOfReturnLotto.totalRatePercentCal();
        System.out.println(String.format(ProgressLottoMessage.RATE_OF_RETURN_MESSAGE,totalRatePercent));
    }

}
