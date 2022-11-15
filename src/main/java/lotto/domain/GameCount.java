package lotto.domain;

public class GameCount {
    private int[] gameCount;
    public GameCount(int size){
        gameCount = new int[size];
    }
    public void addIndex(int index){
        gameCount[index]++;
    }
    public int[] getGameCount(){
        return gameCount;
    }
}
