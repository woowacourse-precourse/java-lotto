package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final LottoNumber lottoNumber;
    private final LottoTickets lottoTickets;
    public static List<Integer> Resultlotto;

    public WinningNumbers(LottoNumber lottoNumber, LottoTickets lottoTickets) {
        this.lottoNumber = lottoNumber;
        this.lottoTickets = lottoTickets;
    }

    public void abc(){
        Resultlotto = new ArrayList<>();

    }

    public int countCorrectNumbers(List<LottoNumbers> ComputerLottoNumbers, List<Integer> userLottoNumbers){
        int count = 0;
        for(int i=0; i<ComputerLottoNumbers.size(); i++){
            if(userLottoNumbers.contains(ComputerLottoNumbers.get(i))){
                count ++;
            }
        }
        return count;
    }
}
