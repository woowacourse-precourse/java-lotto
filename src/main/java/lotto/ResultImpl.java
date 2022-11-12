package lotto;

public class ResultImpl implements Result{

    private String result = Result.Origin;


    @Override
    public void ReturnResult(int three,int four,int five,int FiveS,int six){

        System.out.printf(result,three,four,five,FiveS,six,62.5);
    }
}
