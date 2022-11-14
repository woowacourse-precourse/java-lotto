package lotto;

public enum NumberType {
    NUMBER_START(1),
    NUMBER_END(45),
    NUMBER_COUNT(6);

    private int number;
    NumberType(int number){
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }
}
