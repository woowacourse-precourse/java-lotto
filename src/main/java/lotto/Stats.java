package lotto;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private List<Integer> stats = new ArrayList<>();
    private Integer total = 0;

    public Stats() {
        for (int i=0; i<5; i++) {
            this.stats.add(0);    
        }
    }

    public List<Integer> getStats() {
        return stats;
    }

    public Integer getTotal() {
        return total;
    }

    public void setStats(int index, int value) {
        this.stats.set(index, value);
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
