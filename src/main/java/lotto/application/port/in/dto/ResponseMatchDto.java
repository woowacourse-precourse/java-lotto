package lotto.application.port.in.dto;

import lotto.domain.result.ResultTable;

public class ResponseMatchDto {

    ResultTable resultTable;

    public ResponseMatchDto(ResultTable resultTable) {
        this.resultTable = resultTable;
    }

    public ResultTable getResultTable() {
        return resultTable;
    }
}
