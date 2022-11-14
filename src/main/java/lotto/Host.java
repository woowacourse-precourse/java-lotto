package lotto;

import java.util.ArrayList;
import java.util.List;

public class Host {

    List<Integer> winNumbers;
    int bonusNumber;

    List<List<Integer>> issuanceHistory;

    public Host() {
        issuanceHistory = new ArrayList<>();
    }

    public void registerWinningInformation(List<Integer> winNumbers, int bonusNumber){
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto issueLotto(){
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers;
        while (true){
            numbers = numberGenerator.generateSixRandomNumbers();
            if (!isIssued(numbers)){
                issuanceHistory.add(numbers);
                break;
            }
        }
        return new Lotto(numbers);
    }

    private boolean isIssued(List<Integer> numbers){
        return false;
    }

    public void showWinResult(User user){
        System.out.println("당첨 통계\n---\n");
    }
}
