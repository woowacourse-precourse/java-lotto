
## 기능 요구 사항

- 로또 번호의 숫자 범위는 1~45까지이다. -> 로또 번호 랜덤생성기 구현 
  - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. -> 로또 번호 랜덤생성기 조건. 중복X. 6개 뽑기
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. -> 로또번호 당첨번호 비교. 조건에 맞는지
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. -> 로또 구입 기능구현
- 로또 1장의 가격은 1,000원이다. 로또가격
- 당첨 번호와 보너스 번호를 입력받는다. -> 당첨번호, 보너스 번호 입력 및 저장 구현
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. -> 당첨내역, 수익률 출력 기능 구현 
---
## 기능목록

- [X] 로또번호 랜덤생성기 구현 - LottoGenerator
  - [X] 구입기능 구현 - LottoGenerator 생성자
  - [X] 생성해야 할 로또 수 리턴하는 메소드 - getGenerateCount
    - [X] 1000원 단위, 1000원 단위X 체크 - LottoGenereator#checkMoneyUnit
  - [X] 생성번호 필요조건: 중복X. 번호개수는 6개 고정 - LottoGenerator#createLottoNumber


- [X] 당첨 번호 구현 WinningNumber
  - [X] 당첨번호 입력 조건: 번호개수 6, 중복X, 쉼표 기준 
    -  중복확인 - WinningNumber#checkDuplicateNumber
    -  번호 개수 6개 확인 - WinningNumber#checkWinNumberSize
    -  번호 범위 유효확인 - WinningNumber#checkNumberRange
  - [X] 보너스 번호 입력 조건, 당첨번호와 중복X


- [X] 로또 등수 구현: Lotto#lottoChecker
  - [X] 로또 번호, 당첨 번호 비교 Lotto#compareNumber
    - [X] 2등 조건 구현 Lotto#secondPlaceCheck
    - [X] 당첨 갯수에 따른 순위 제공 Lotto#rankCheck

  
- [X] 결과 출력
  - [X] 당첨내역
  - [X] 수익률


- [X] 등수 출력 내용: Enum - LottoReference
  - [X] 등수로 Enum 내 열거 상수 조회 - LottoReference#getRankByMatchCount
  - [X] 등수에 따른 상금 및 설명 출력 - LottoReference#getWinInformation
  - [X] 등수에 따른 상금 출력 - LottoReference#getPrizeMoney
