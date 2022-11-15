package lotto.object;

import java.text.DecimalFormat;

public class Yield {
    private Long principal;
    private Long revenue;

    public Yield(Long principal, Long revenue) {
        this.principal = principal;
        this.revenue = revenue;
    }

    public Yield(Long principal) {
        this.principal = principal;
        this.revenue = 0L;
    }

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Float getYield() {
        return ((float) revenue / (float) principal) * 100;
    }

    @Override
    public String toString() {
        return String.format("%.1f%%", this.getYield());
    }
}
