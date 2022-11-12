package lotto.application.dto;

public class WinStat {
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;
    public WinStat(){
        one=0;
        two=0;
        three=0;
        four=0;
        five=0;
    }
    public void updateOne(){
        one+=1;
    }
    public void updateTwo(){
        two+=1;
    }public void updateThree(){
        three+=1;
    }public void updateFour(){
        four+=1;
    }public void updateFive(){
        five+=1;
    }

    public Integer getOne() {
        return one;
    }

    public Integer getTwo() {
        return two;
    }

    public Integer getThree() {
        return three;
    }

    public Integer getFour() {
        return four;
    }

    public Integer getFive() {
        return five;
    }
}
