package lotto;


import java.util.HashSet;
import java.util.List;
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
    public void isLottoOverlap(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        if(set.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.OverlapExist.getMsg());
        }
    }
    public void isLottoOverlap(Lotto lotto){
        if(setSize(lotto) != 6) {
            throw new IllegalArgumentException(ErrorMessage.OverlapExist.getMsg());
        }
    }
    private int setSize(Lotto lotto){
        Set<Integer> set = new HashSet<>(lotto.getLotto());
        return set.size();
    }
}
