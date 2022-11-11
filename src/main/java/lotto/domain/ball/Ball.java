package lotto.domain.ball;

public class Ball {
    private final BallEnum type;
    private final Integer number;
    
    public Ball(BallEnum type, Integer number) {
        this.type = type;
        this.number = number;
    }
    
    public BallEnum getType() {
        return type;
    }
    
    public Integer getNumber() {
        return number;
    }
}
