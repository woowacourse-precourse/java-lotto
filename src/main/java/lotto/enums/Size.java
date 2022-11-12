package lotto.enums;

public enum Size {
    LOTTERY_SIZE(6);
    private  Integer size;
    private Size(Integer size){
        this.size = size;
    }
    public Integer getSize(){
        return size;
    }
}
