
## 기능 목록
###1. 입력 처리
#### 입력은 모두 주어진 API로 한 줄씩 입력받아 처리한다.
    1) 입력을 int로 변환
        / int getInputToInt(String readLine)
    2) 당첨 번호 처리 
        / List<Interger> getWinningNumber(String readLine)
###2. 로또 발행
    1) 로또 1개 숫자 발행 
        / List<Integer> getLottoNumbers()
    2) 사용자의 구매횟수만큼 getLottoList를 호출해서 리스트에 넣음
        / List<List<Integer>> getPurchaseLottoList(int purchaseNumber)
###3. 당첨 확인
    1) 숫자 포함 여부 확인
        / boolean isContainNumber(int LottoNumber)
    2) 당첨갯수 확인
        / int getMatchingNumber(List<Integer> LottoNumbers)
    3) 당첨갯수를 통해 당첨배열 인덱스 정하는 메소드
        / getWinningIndex(List<Integer> lotto, int bonus)
    4)  3)를 가지고 당첨배열 생성 [3개, 4개, 5개, 6개, 5개+보너스] 
        / int[] getWinningArray(List<List<Integer>> getPurchaseLottoList)

###4. 수익률 계산
    1) 수익 계산 // 추후 enum으로 리팩토링
        / int getProfit(int[] WinningArray)
    2) 수익율 계산
        / double getEarningsRate(int purchaseCost, int [] winningArray)
###5. 예외 처리
    1) 구입금액에 숫자가 아닌 문자열이 입력되었을 때
    2) 구입금액이 1000의 배수가 아닐 때
    2) 잘못된 로또번호 오류
    3) 잘못된 로또번호 수 오류
###6. 출력 처리
    1) 구매 로또 번호 출력
        / String printPurchaseLottoList(List<List<Integer> PuchasesLottoList)
    2) 당첨 통계 출력
        / String printWinningStatistics(int[] winningArray)
