#기능 정리

## 패키지별 역할 및 기능

- domain
  - Lotto : 
    1. 로또 1장의 번호 정보를 저장
  - Lottos :
    1. 이용자의 모든 구매 로또 정보를 저장
  - LottoNumber :
    1. 사용 가능한 로또 번호 정보 캐싱
  - PrizeMoney :
    1. 상금 액수에 대한 원시 값
  - LottoPieces :
    1. 금액에 따라 구매 가능한 로또 장 수 계산
  - Prize :
    1. 상금 정보 명시
  - PrizeBoard :
    1. 결과에 따른 상금 반환
- strategy 
  - LottoGenerateStrategy :
    1. 구매한 로또 번호 생성 전략
  - RandomLottoGenerateStrategy
    1. 구매한 로또 번호 랜덤 생성 전략
- view
  - UserInput :
    1. 유저의 입력 값을 받는 기능
  - PrintResult :
    1. 특정 결과를 화면에 출력하는 기능