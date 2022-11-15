package lotto.domain;

import java.util.List;

public class Print {

    public void lottoCount(int lottocount){
        System.out.println(String.format("%d개를 구매했습니다.", lottocount));
    }

    public void lottoNumber(List<List> userlottos){
        for (int i = 0; i < userlottos.size(); i++){
            System.out.println(userlottos.get(i));
        }
    }
}
