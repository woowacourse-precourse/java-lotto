package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(){
        this.lottos = new ArrayList<>();
    }

    public void setLottos(int trial) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        for(int i = 0; i < trial; i++){
            this.lottos.add(lottoGenerator.generateLotto());
        }
    }

    public int getCountOfLotto(){
        return this.lottos.size();
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public void print(){
        for(Lotto lotto : lottos){
            lotto.print();
        }
    }

    public Statistic getWinningStatistics(WinningLotto winningNumber) {
        List<Rank> ranks = lottos.stream()
                .map(winningNumber::match)
                .collect(Collectors.toList());
        return Statistic.valueOf(ranks);
    }
}
