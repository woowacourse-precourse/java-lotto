package lotto;

import java.util.List;

public class Host {

    List<Integer> winNumbers;
    int bonusNumber;

    public void registerWinningInformation(List<Integer> winNumbers, int bonusNumber){

    }

    public Lotto issueLotto(){
        return null;
    }

    private boolean isIssued(List<Integer> numbers){
        return false;
    }

    public void showWinResult(User user){
        System.out.println("당첨 통계\n---\n");
    }
}
