package lotto.controller;


import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

// 로또 자동 분배 기능
public class AutomaticDispenser {

    private Map<Integer, List<Integer>> drawingMachine;


    public AutomaticDispenser() {
        this.drawingMachine = dispenseAutomatically();
    }

    // 로또 랜덤 번호 리스트 생성
    public List<Integer> buildLottoList() {

        Lotto createLottoNumber = new Lotto(pickUniqueNumbersInRange(1, 45, 6));

        List<Integer> lottoNumberList = createLottoNumber.typeToList();

        return lottoNumberList;

    }

    // 로또 발행 수 만큼 자동 생성
    public Map<Integer, List<Integer>> dispenseAutomatically() {

        drawingMachine = new HashMap<>();

        int lottoTickets = new LottoTicket().publishLottoTicket();

        for ( int i = 0; i < lottoTickets; i ++){
            drawingMachine.put(lottoTickets, buildLottoList());
        }

        return drawingMachine;
    }



}
