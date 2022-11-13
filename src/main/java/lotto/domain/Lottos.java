package lotto.domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<Lotto>();

    public Lottos(int paper){
        make_lottos(paper);
        System.out.println(lottos);
    }

    private void make_lottos(int paper){
        for (int i = 0; i < paper; i++){
            lottos.add(make_lotto());
        }
    }

    private Lotto make_lotto(){
        return new Lotto(make_numbers());
    }

    private List<Integer> make_numbers(){
        return new Numbers().Get_Numbers();
    }

    public Lotto Get_lotto(int index){
        return lottos.get(index);
    }
}
