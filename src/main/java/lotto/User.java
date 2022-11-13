package lotto;

import lotto.UI.ERRORUI;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private Integer cntLotto;
    private static final int lottoValue = 1000;

    public void purchaseLotto(String input){
        try {
            Integer value = checkNum(input);
            int cntLotto = divideLotto(value);
            setLotto(cntLotto);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorDivideValue();
            System.exit(1);
        }
    }
    private Integer checkNum(String input){
        Integer value = null;
        try {
            value = Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
        }
        return value;
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

    public List<Lotto> getLottos(){
        return lottos;
    }

    public Integer getCntLotto(){return cntLotto;}
}
