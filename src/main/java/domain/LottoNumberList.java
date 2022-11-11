package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberList {
    private List<List<Integer>> lottolist = new ArrayList<>();

    public LottoNumberList(List<List<Integer>> lottolist) {
        this.lottolist = lottolist;
    }

    public List<List<Integer>> getLottolist() {
        return lottolist;
    }
}
