package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinStatistics {
    private static int bonusAccord = 0;
    private static List<Integer> countAccord = new ArrayList<>();
    private UserLotto userLotto = new UserLotto();
    private WinLotto winLotto = new WinLotto();
    private List<List> userLottoNumbers;
    private List<Integer> winLottoNumbers;
    private int bonusNumber;

    public WinStatistics() {
    }

    public void startWinStatistics() {
        userLottoNumbers = userLotto.getUserLotto();
        winLottoNumbers = winLotto.getWinningNumbers();
        bonusNumber = winLotto.getBonusNumber();
        initCountAccord();

        for (int i = 0; i < userLottoNumbers.size(); i++) {
            List<Integer> userNumbers = new ArrayList<>(userLottoNumbers.get(i));
            checkLottoNumbers(userNumbers, winLottoNumbers);
        }
    }

    public void checkLottoNumbers(List<Integer> userNumbers, List<Integer> winLottoNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.contains(winLottoNumbers.get(i))) {
                count++;
            }
        }
        checkAccord(count,userNumbers);
    }

    public void checkAccord(int count,List<Integer> userNumbers) {
        if (count != 5) {
            countAccord.set(count,countAccord.get(count)+1);
        }else{
            checkBonus(userNumbers,count);
        }
    }

    public void checkBonus(List<Integer> userNumbers,int count){
        if(userNumbers.contains(bonusNumber)){
            bonusAccord++;
        }else{
            countAccord.set(count,countAccord.get(count)+1);
        }
    }

    public List<Integer> getCountAccord(){
        return countAccord;
    }

    public int getBonusAccord(){
        return bonusAccord;
    }

    public void initCountAccord(){
        for(int i=0;i<7;i++){
            countAccord.add(0);
        }
    }
}
