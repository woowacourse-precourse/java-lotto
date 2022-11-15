package lotto;

public class Count {
    private int count;
    private Result result;
    private int totalMoney;

    public Count(Result result) {
        this.result = result;
        this.count = 0;
        this.totalMoney = 0;
    }

    public void setCount(){
        this.count++;
        this.totalMoney = this.count * this.result.getReward();
    }
    public int getTotalMoney(){
        return this.totalMoney;
    }
    public int getCount(){
        return this.count;
    }
}
