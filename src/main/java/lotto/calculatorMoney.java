package lotto;

public class calculatorMoney {
    private int winningMoney;
    private String getAmountInput;
    private int[] result;
    public calculatorMoney(String getAmountInput,int[] result){
        this.winningMoney=0;
        this.result=result;
        this.getAmountInput=getAmountInput;

    }
    public void sumWinningMoney(){
       this.winningMoney+= result[1]*2000000000;
        this.winningMoney+= result[2]*30000000;
        this.winningMoney+= result[3]*1500000;
        this.winningMoney+= result[4]*50000;
        this.winningMoney+= result[5]*5000;

    }
    public int getAmountInput(){
        return Integer.parseInt(this.getAmountInput);
    }
    public int getWinningMoney(){
        return this.winningMoney;
    }
    public double profitRate(){
        double profitRate=(double)winningMoney/Double.parseDouble(getAmountInput);
        return Math.round(profitRate*10)/10.0;


    }
    public void printProfitRate(){

        System.out.println("총 수익률은 "+profitRate()+"%입니다.");
    }
}
