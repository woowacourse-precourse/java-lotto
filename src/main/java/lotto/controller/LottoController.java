package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;

public class LottoController {
    private List<Lotto> lottos;
    private LottoAnswer lottoAnswer;
    private LottoResult lottoResult; // 등수별 결과를 담는 리스트
    private final LottoResultController lottoResultController;

    public LottoController() {
        this.lottoResultController = new LottoResultController(lottoAnswer, lottos);
    }

    public void run() {
        // 먼저 가격을 입력받음.
        // 개수에 맞는 로또를 생성 및 출력함.
        // 그 로또로 결과를 생성함.
        // 결과를 이용하여 출력함.
    }
}
