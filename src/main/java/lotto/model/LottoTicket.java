package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.*;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(long count){
        generateTickets(count);
    }

    private void generateTickets(long count){
        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            try {
                lottoTickets.add(new Lotto(numbers));
            } catch(IllegalArgumentException e){
                OutputView.printException(e);
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }



}
