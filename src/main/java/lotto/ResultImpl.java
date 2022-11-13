package lotto;

public class ResultImpl implements Result{

    private String result = Result.Origin;


    @Override
    public void ReturnResult(int three,int four,int five,int FiveS,int six,int money){
        double percent = (((three*5000)+(four*50000)+(five*1500000)+(FiveS*30000000)+(six*2000000000))/(double)money)*100;
        System.out.printf(result,three,four,five,FiveS,six,percent);
    }
}
