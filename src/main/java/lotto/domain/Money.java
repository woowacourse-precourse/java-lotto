package lotto.domain;


public class Money {
    private static final String ERROR_LOTTO_THOUSAND = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final String ERROR_LOTTO_ISDIGIT = "[ERROR] 구입 금액은 실수여야합니다.";
    private int winningMoney;
    private String getAmountInput;
    public Money(String getAmountInput){
        this.winningMoney=0;
        this.getAmountInput=getAmountInput;
        checkMoney(getAmountInput);
        isThousand(getAmountInput);
    }
    private void checkMoney(String money){
        for(int i=0;i<money.length();i++){
            checkDigit(money.charAt(i));
        }
    }
    private void isThousand(String money){
        if(Integer.parseInt(money)%1000!=0){
            throw new IllegalArgumentException(ERROR_LOTTO_THOUSAND);
        }
    }
    private void checkDigit(char ch){
        if(Character.isDigit(ch)!=true){

            throw new IllegalArgumentException(ERROR_LOTTO_ISDIGIT);
        }
    }
    public void sumWinningMoney(Rank rank){
       this.winningMoney+= rank.getValue();

    }
    public int getAmountInput(){
        return Integer.parseInt(this.getAmountInput);
    }
    public int getWinningMoney(){
        return this.winningMoney;
    }
    public double profitRate(){
        double profitRate=(double)winningMoney/Double.parseDouble(getAmountInput)*100;
        return Math.round(profitRate*10)/10.0;


    }
    public void printProfitRate(){

        System.out.println("총 수익률은 "+profitRate()+"%입니다.");
    }
}
