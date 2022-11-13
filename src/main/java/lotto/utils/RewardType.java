package lotto.utils;

enum RewardType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int num;
    private int reward;

    RewardType(int num, int reward){
        this.num = num;
        this.reward = reward;
    }
    public int getnum() {
        return num;
    }
    public int getreward(){
        return reward;
    }
}
