## 기능목록

1. 주기능

| 기능이름 | 기능 세부사항 | 
|:---:|---|
|Lotto|로또|
|Lotto.validate|로또 번호를 검증한다|
|Lotto.autoGenerateNumbers|자동으로 로또 번호를 생성|
|LottoeryStore|로또의 판매처|
|LottoeryStore.purchaseLottery|로또를 금액에 맡게 발행|
|LotteryHostAgency.draw|당첨번호를 추첨|
|LotteryHostAgency.getResult|당첨 번호에 대한 결과를 반환|
|LotteryHostAgency.WinningCriteria|당첨기준|
|LotteryHostAgency.WinningCriteria.amount|당첨기준의 등수에 따른 당첨금액|
|Application.getEarningsRate|수익률 계산|
|Application.printWiningStats|당첨 통계를 출력|

1. 보조기능

| 기능이름 | 기능 세부사항 |  종속 기능 |
|:---:|---| --- |
|LottoeryHostAgency.validate| 당첨 번호를 검증 | |
|LotteryHostAgency.setWinningNumbers| 당첨 번호를 설정 | |
|LotteryHostAgency.setBonusNumber| 보너스 번호를 설정| |
|Application.getTotalAmount|총 금액을 출시| |
|Application.validatePurchaseAmount|입력한 구입 금액을 검증| |
|Application.validateDrawalNumbers|입력한 구입번호와 당첨번호를 보너스 번호를 검증| |


1. 상태 
| 기능이름 | 기능 세부사항 | 
|:---:|---|
|Application.purchaseAmount|구매금액|
|Application.totalAmount|총 금액|



