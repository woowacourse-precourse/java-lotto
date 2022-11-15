## 🚀 기능 목록

### 2주차 피드백
-세세한 부분까지 정리하기보다 구현해야 할 기능 목록을 정리하는 데 집중한다.(구현, 함수, 메서드)
-예외적인 사항도 기능목록에 정리한다
-기능을 구현하면서 문서를 계속 업데이트 한다

<br><br>
### 기능목록
[constant]
- 로또 관련 상수정보 [ x ] - LottoInfo(enum)
- 랭킹 관련 상수정보 [ x ] - RankInfo(enum)


[controller]
- 로또 게임을 시작한다 [ x ] - ApplicationManager#run()

- 로또 당첨 번호 6자리를 입력받는다 [ x ] - LottoManager#GenerateLottoNumbers()
- 보너스 번호를 입력받는다 [ x ] -  LottoManager#GenerateBonusNumber()
- 사용자의 로또 6자리 숫자를 발행한다 [ x ] - LottoManager#GenerateRandomNumbers()
- 사용자로부터 금액을 입력받는다 [ x ] - LottoManager#getMoney()
- 6자리 로또를 오름차순 정렬한다 [ x ] - LottoManager#sortLottoNumbers()
- 로또금액에 맞는 로또 발행 개수 구한다 [ x ] - LottoManager#getNumberLottos()
- 발행된 로또 개수를 출력한다 [ x ] - LottoManager#printPublishedLottos()
- 금액에 맞는 양 만큼 로또를 발행한다 [ x ] - LottoManager#publishLottoForPrice()
- 당첨금액 출력 [ x ] - LottoManager#printWinningMessage()
- 수익률 출력 [ x ] - printProfit()

[model]
- 당첨번호와 사용자가 가진 로또들을 비교할 수 있다 [ x ] - Referee#compare()
  - 중복되는 숫자 개수를 카운트한다 [ x ] - Judgment#correctCount()
  - 비교 결과를 초기화한다 [ x ] - Referee#initHashMap()
  - 로또 당첨등수를 확인한다 [ x ] - - Referee#countNumberRank()
    - 보너스 번호가 있는지 카운트한다 [ x ] - Judgment#hasBonusNumber()
- 로또 번호가 유효한지 확 [ x ] - Lotto#validate()
- 로또 번호를 반환 [ x ] - Lotto#get()

[view]
- 구매금액 요청 메세지 출력 [ x ] - OutputView#informNumberPurchases()
- 로또 번호 출력 [ x ] - OutputView#printLottoNumber()
- 등수 통계메세지 출력 [ x ] - OutputView#winningStatistic()
- 추익률 출력 [ x ] - OutputView#printTotalPrizeRate()


<br><br>
### 예외적인 사항
- 로또 당첨 번호 구분자가 "," 가 아닐경우
- 로또 당첨 번호가 6자리가 아닌경우 [ x ]
- 로또 당첨 번호가 중복될 경우 [ x ]
- 로또 당첨 번호가 1~45 범위가 아닐 경우
- 보너스 번호가 1~45가 아닐 경우

- 사용자가 입력한 금액이 1000으로 나누어 떨어지지 않을 경우
- 발권한 로또 번호가 6자리가 아닐경우
- 발권한 로또 번호가 중복될 경우
- 발권한 로또 번호가 1~45범위가 아닐 경우