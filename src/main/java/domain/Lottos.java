package domain;

import dto.LottosDto;
import dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDto sendDto() {
        return new LottosDto(lottos);
    }

    public Integer getSize(){
        return lottos.size();
    }

    public Result totalResult(WinningNumberDto winningNumberDto){
        Result result = new Result();
        for(Lotto lotto : lottos){
            LottoRank rank = lotto.countHit(winningNumberDto);
            result.increment(rank);
        }
        return result;
    }
}
