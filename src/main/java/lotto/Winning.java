package lotto;

import lotto.UI.ERRORUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {

    private List<Integer> winnings;

    private Integer bonus;

    //당첨 통계 갯수 저장소
    private List<Integer> countWin = new ArrayList<>(Arrays.asList(0,0,0,0,0));

    public void setWinnings(String input) {
        List<Integer> check = new ArrayList<>();
        String[] str = input.split(",");
        check = checkNum(str);
        if(checkRange(check)){
            winnings = check;
        }
    }

    private List<Integer> checkNum(String[] input){
        List<Integer> num = new ArrayList<>();
        try {
            for (String s : input) {
                num.add(Integer.parseInt(s));
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
            System.exit(0);
        }
        return num;
    }

    private boolean checkRange(List<Integer> check){
        try {
            checkIndex(check);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorRange();
            System.exit(0);
        }
        return true;
    }

    private void checkIndex(List<Integer> check) throws IllegalArgumentException{
        for(Integer integer : check){
            if(integer<1 || integer>45){
                throw  new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getWinnings(){
        return winnings;
    }

    public void setBonus(String s){
        Integer check = checkBonusNum(s);
        if(checkBonusRange(check)) {
            bonus = check;
        }
    }

    private Integer checkBonusNum(String s){
        Integer bonus = null;
        try {
            bonus = Integer.parseInt(s);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
            System.exit(0);
        }
        return bonus;
    }

    private boolean checkBonusRange(Integer bonus){
        try {
            if(bonus <1 || bonus >45){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorRange();
            System.exit(0);
        }

        return true;
    }

    public Integer getBonus(){
        return bonus;
    }

    public List<Integer> getTotalWinning(List<Lotto> user){

        for(Lotto lotto: user){
            int sussecc = matchWinningLotto(lotto.getLotto());
            if(sussecc==3){
                countWin.set(0,countWin.get(0)+1);
            }
            if(sussecc==4){
                countWin.set(1,countWin.get(1)+1);
            }
            if(sussecc==5 && !matchBounsLotto(lotto.getLotto())){
                countWin.set(2,countWin.get(2)+1);
            }
            if(sussecc==5 && matchBounsLotto(lotto.getLotto())){
                countWin.set(3,countWin.get(3)+1);
            }
            if (sussecc==6){
                countWin.set(4,countWin.get(4)+1);
            }
        }
        return countWin;
    }
    public Integer matchWinningLotto(List<Integer> lotto){
        int success = 0;
        for(Integer integer : lotto){
            if(compareWinning(integer)) success++;
        }
        return success;
    }

    private boolean compareWinning(int value){
        for(Integer integer : winnings){
            if(integer.equals(value)){
                return true;
            }
        }
        return false;
    }

    public boolean matchBounsLotto(List<Integer> lotto){
        for(Integer integer : lotto){
            if(integer.equals(bonus)) return true;
        }
        return false;
    }

    public Double getToTalRate(int value){
        double total =0;
        for(int i=0 ; i<5 ; i++){
            if(i == 0){
                total +=(countWin.get(0) * 5000);
            }
            if(i == 1){
                total += (countWin.get(1) * 50000);
            }
            if(i == 2) {
                total += (countWin.get(2) * 1500000 );
            }
            if(i == 3){
                total += (countWin.get(3) * 30000000 );
            }
            if(i == 4){
                total += (countWin.get(4) * 2000000000);
            }
        }
        return total/value;
    }
}
