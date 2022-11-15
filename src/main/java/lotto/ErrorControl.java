package lotto;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ErrorControl {

    public ErrorControl(){

    }

    public void ticketPurchaseStrError(String input){
        if(!input.equals("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PurchaseStr.getMsg());
        }
    }
    public void ticketPurchaseThousandError(int input){
        if(input%1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.PurchaseThousandError.getMsg());
    }
    public void isLottoOver(Lotto lotto){
        if(lotto.getLotto().size() > 7)
            throw new IllegalArgumentException(ErrorMessage.LottoOver.getMsg());
    }
    public void isLottoOverlap(Lotto lotto){
        Lotto tmp = lotto;
        Collections.sort(tmp.getLotto());
        for(int i = 1; i < tmp.getLotto().size(); i++){
            if(tmp.getLotto().get(i) == tmp.getLotto().get(i-1))
                throw new IllegalArgumentException(ErrorMessage.OverlapExist.getMsg());
        }
    }
    private int setSize(Lotto lotto){
        Set<Integer> set = new HashSet<>(lotto.getLotto());
        return set.size();
    }
    public void isInputLottoNumberNotSix(String s){
        String[] sp = s.split(",");
        if(sp.length != 12)
            throw new IllegalArgumentException(ErrorMessage.LottoNotSix.getMsg());
    }
    public void isInputLottoNumberStr(String s){
        String[] sp = s.split(",");
        if(!sp[0].equals("-?\\d+") || !sp[2].equals("-?\\d+") || !sp[4].equals("-?\\d+") || !sp[6].equals("-?\\d+") || !sp[8].equals("-?\\d+") || !sp[10].equals("-?\\d+"))
            throw new IllegalArgumentException(ErrorMessage.LottoNumberStr.getMsg());
    }
}
