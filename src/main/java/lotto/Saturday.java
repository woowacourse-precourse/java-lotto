package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Saturday {
    private List<Integer> winNumbers;
    private int winBonus;

    Saturday(String input_win,String input_bonus)throws IllegalArgumentException{
        validateStrInput(input_win,input_bonus);
        String[] numbers = input_win.split(",");
        List<Integer> win = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++){
            win.add(Integer.parseInt(numbers[i]));
        }
        int bonus = Integer.parseInt(input_bonus);
        win.sort(Comparator.naturalOrder());
        validateIntInput(win,bonus);
        this.winNumbers = win;
        this.winBonus = bonus;
    }


    public void validateStrInput(String win,String bonus)throws IllegalArgumentException{
        if(!isWinRegex(win)) throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해 주세요");
        if(!isBonusRegex(bonus)) throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해 주세요");
    }
    public void validateIntInput(List<Integer> win,int bonus) throws IllegalArgumentException{
        if(isOut(win,bonus)) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        if(isAlready(win,bonus)) throw new IllegalArgumentException("[ERROR] 이미 있는 당첨 번호 입니다.");
    }
    public boolean isWinRegex(String win){
        return win.matches(Numbers.Win.regex);
    }
    public boolean isBonusRegex(String bonus){
        return bonus.matches(Numbers.Bonus.regex);
    }

    public boolean isOut(List<Integer> win,int bonus){
        for(int i=0; i<6; i++){
            if(win.get(i)>45)return true;
        }
        if(bonus>45) return true;
        return false;
    }
    public boolean isAlready(List<Integer> win,int bonus){
        return win.contains(bonus);
    }
    public boolean checkNumber(int number){
        int l,r,mid,value;
        l=0;
        r=5;
        while(l<=r){
            mid = (l+r)/2;
            value=winNumbers.get(mid);
            if(number==value)return true;
            if(number>value){
                l=mid+1;
                continue;
            }
            r=mid-1;
        }
        return false;
    }
    public int checkLottoAt(int i){
        Lotto lotto = DB.selectAt(i);
        List<Integer> numbers = lotto.getNumbers();
        int count=0;
        int flag=0;
        for(int j=0; j<numbers.size(); j++){
           if(checkNumber(numbers.get(j))) count++;
           if(numbers.get(j)==winBonus) flag=1;
        }
        if(flag==1 && count==5)return count*10;
        if(flag==1 && count<5) return count+1;
        return count;
    }
    public void makeStatistics(){
        List<Integer> statistics = new ArrayList<>(List.of(0,0,0,0,0));

        int size = DB.getTableSize();
        int count,index,prizeSum=0;
        for(int i=0; i<size; i++){
            count = checkLottoAt(i);
            if(count>=3){
                index=Winner.getStatisticsIndex(count);
                statistics.set(index,statistics.get(index)+1);
                prizeSum +=Winner.getPrize(count);
                
            }
        }
        System.out.println("statistics = " + statistics);
        System.out.println("prizeSum = " + prizeSum);
        DB.setStatistics(statistics);
        DB.setPrizeSum(prizeSum);
        
    }

    public void calYeild(){
        DB.setYeild( (double)DB.getPrizeSum()*100/(DB.getTableSize()*1000));
    }
}
