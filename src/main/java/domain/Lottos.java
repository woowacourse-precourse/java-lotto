package domain;

import dto.LottosDto;

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


}
