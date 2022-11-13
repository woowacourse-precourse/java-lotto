package lotto.domain;

import javax.swing.*;

public class Earning {
    private int earning;
    private String earning_percent;

    public Earning(Score score){
        for (int i = 0; i < score.Get_size(); i++) {
            Plus_score(score.Get_val(i), Select_price(i));
        }
    }

    public void Set_percent(int money){
        earning_percent = String.format("%.1f", (double) earning / money * 100);
    }

    private void Plus_score(int score, int won){
        earning += score * won;
    }

    private int Select_price(int index){
        if (index == 0)
            return price.Five_thousand.getValue();
        if (index == 1)
            return price.Fifty_thousand.getValue();
        if (index == 2)
            return price.A_million_and_a_half_million.getValue();
        if (index == 3)
            return price.Thirty_million.getValue();
        if (index == 4)
            return price.Two_billion.getValue();
        return -1;
    }

    public String Get_percent(){
        return earning_percent;
    }
}
