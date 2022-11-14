package lotto;

import lotto.UI.ERRORUI;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private Integer cntLotto = null;
    private static final int lottoValue = 1000;

    public void purchaseLotto(String input){
        Integer value = checkNum(input);
        cntLotto = divideLotto(value);
        setLotto(cntLotto);
    }
    private Integer checkNum(String input){
        Integer value = null;
        try {
            value = Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
            System.exit(0);
        }
        return value;
    }

    private Integer divideLotto(int value){
        try {
            if(value%lottoValue!=0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorDivideValue();
            System.exit(0);
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
            System.exit(0);
        }
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public Integer getCntLotto(){return cntLotto;}

}
