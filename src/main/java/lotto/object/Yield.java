package lotto.object;

import java.text.DecimalFormat;

public class Yield {
    private Integer principal;
    private Integer revenue;

    public Yield(Integer principal, Integer revenue) {
        this.principal = principal;
        this.revenue = revenue;
    }

    public Yield(Integer principal) {
        this.principal = principal;
        this.revenue = 0;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Float getYield() {
        return ((float) revenue / (float) principal);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##%");

        return df.format(this.getYield());
    }
}
