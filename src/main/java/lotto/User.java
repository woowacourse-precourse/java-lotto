package lotto;

import lotto.UI.ERRORUI;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private Integer cntLotto;
    private static final int lottoValue = 1000;

    public void purchaseLotto(int value){
        try {
            int cntLotto = divideLotto(value);
            setLotto(cntLotto);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorDivideValue();
            System.exit(1);
        }
    }

    private Integer divideLotto(int value){
        if(value%lottoValue!=0){
            throw new IllegalArgumentException();
        }
        return value/lottoValue;
    }

    private void setLotto(int num){
        try{
            for(int i=0;i<num;i++) {
                Lotto lotto = new Lotto(Random.randomList());
                lottos.add(lotto);
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorLotto();
            System.exit(1);
        }
    }
}
