package lotto.service;

import lotto.view.LottoView;

public class LottoService {

    private LottoView lottoView;

    public LottoService() {}

    // 로또 시작
    public void initLotto() {
        try {
            this.lottoView = new LottoView();
            lottoView.lottoSetView();
            createLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    // 당첨번호 생성
    private void createLottoNumber() throws IllegalArgumentException{
        lottoView.lottoNumberMessage();
        createBonusNumber();
    }

    // 보너스번호 생성
    private void createBonusNumber() {
        lottoView.printLottoBonus();
        winningStatistics();
    }

    // 당첨 통계메시지 출력
    private void winningStatistics() {
        lottoView.lottoWinningMessage();
        winningResult();
    }

    // 당첨 통계 결과 출력
    private void winningResult() {
        lottoView.lottoWinningResult();
        rateOfReturnResult();
    }

    // 총 수익률 결과 출력
    private void rateOfReturnResult() {
        lottoView.rateOfReturnResult();
    }
}
