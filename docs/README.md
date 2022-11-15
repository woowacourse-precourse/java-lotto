## inputView
### inputMoney
* 로또 구입 금액 입력받기
    + “구입 금액을 입력해주세요”
    + readLine()
### imputWinningLottosNumber
    + "당첨번호를 입력해 주세요"
### inputBonusNumber
    + "보너스 번호를 입력 해 주세요"

***
## InputValidator
* inputView에서 입력 받은 값 형변환
- 예외사항
  - 숫자만 입력가능
  - 당첨번호는 ,로 구분되어야 함
  - 금액은 1000원 단위여야 함
  - 보너스 숫자는 1-45 사이여야 함
  - 보너스 숫자는 당첨 번호와 중복될 수 없음

***
## OutputView
### printUserBuyLottoNumbers
* 구매한 로또 번호 출력
    +"개를 구매했습니다."
    + 오름차순 정리
    + [ , , , , , ]
      > 배열을 그대로 출력? 아니면 반복문 사용? 스트림 사용?
### printUserLottoMatchResult
* 당첨 결과 출력
    + “—당첨 통계—”
  > 위에서 만든 조건별 메소를 출력하면 될듯
### printRateOrReturn
* 수익률 출력
  +"총 수익률을 %입니다."

***
## creatNumbers
### createYourLottoNumbers
* 입력된 금액 확인 후 로또 번호 생성
  + inputMoney 입력값 확인
  + 구매 개수만큼 로또 번호 생성
  > 로또를 1개 이상 산 경우 어떻게 해야할까?

***
## Lotto
*로또 오름차순으로 정렬
### validate
* 구매한 로또 번호 개수가 6개인지 확인

***
## ComparisonContents
* enum 클래스
* 당첨 조건 별 내용 넣제


## 
### getMatchResult
* 구매한 전체 로또와 당첨번호를 비교하기
### usersOneLottoMatchWithWinningNumbers
* 구매한 로또 중 한개를 당첨 번호와 비교
### sortOutWinningPlace
* 당첨 조건 별 카운트 반환값 생성
### sortOutWinningPlace
* 구매한 로또 번호에 보너스 번호가 있는지 확인
### calculateRateOfReturn
* 수익률 계산
+ 소수점 2번째 자리에서 **반올림**