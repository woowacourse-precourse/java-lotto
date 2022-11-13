## view
###inputMoney
* 로또 구입 금액 입력받기
    + “구입 금액을 입력해주세요”
    + readLine()
        - [ ]  `1000원 단위인지 확인`, `IllegalArgumentException`
          ###printYourLottos
    * 구매한 로또 번호 출력 =
    + 오름차순 정리
    + [ , , , , , ]
      > 배열을 그대로 출력? 아니면 반복문 사용? 스트림 사용?
      ###printWinningNumbers
* 로또 당첨 번호 출력
  + "당첨 번호를 입력해 주세요."
  - , 로 숫자 사이 구분자 넣기
  + "보너스 번호를 입력해 주세요."
### printResult
* 당첨 결과 출력
    + “—당첨 통계—”
  > 위에서 만든 조건별 메소를 출력하면 될듯
    + 수익률 출력
***
## creatNumbers
### createWinningNumbers
* 로또 당첨번호 생성 
    + 1-45까지 랜덤 숫자 6개 
    + 선별된 숫자 6개 제외 보너스 숫자 1개
    - Random() 함수 사용
    - List 배열에 담기
###createYourLottoNumbers
* 입력된 금액 확인 후 로또 번호 생성
  + inputMoney 입력값 확인
  + 구매한 로또 개수 확인
  + 로또 번호 생성
  > 로또를 1개 이상 산 경우 어떻게 해야할까?

***
## successOrFailure
### checkNumbers
* 구매한 번호와 당첨 번호 비교 = 
    + 구매한 번호가 당첨 번호에 포함되었는지 확인
    > 구매한 로또가 1개 이상인 경우는 어쩌지?
    + 비교 후 결과 구분해서 넣어주기
			#### placeInLottery
        - 당첨 조건별로 메소드를 만들어보자
					####first 1등: 6개 번호 일치 / 2,000,000,000원
			    ####second 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
			    ####third 3등: 5개 번호 일치 / 1,500,000원
			    ####fourth 4등: 4개 번호 일치 / 50,000원
			    ####fifth 5등: 3개 번호 일치 / 5,000원
	### RateOfReturn
*수익률 계산하기
			+ 소수점 2번째 자리에서 **반올림**