* 로또를 구입하는 단계 - package player
	플레이어 메인 실행 - class Player
	금액 입력 - class Coin - 문구 출력
		오류 확인 - class CoinErrorCheck
	횟수 확인 - class Chance
	횟수 만큼의 복권 생성 - class PlayerChoose
		로또 번호를 출력 - class ShowNums
* 당첨 여부를 확인하는 단계 - package 
	당첨 여부 확인 메인 실행 - calss Confirm
	당첨번호 생성 - class WinNumList
	보너스 번호 입력 - class BonusNum
	오류 확인 - class WinNumErrorCheck
		범위 체크 - class overFlow
		중복 체크 - duplicate check
	당첨리스트 생성 - class WinList
		플레이어 복권과 당첨번호 비교 - class WinNumCheck
			보너스 번호 비교 - calss BonusNumCheck
* 수익성을 확인하는 단계 - package calculate
	수익률 구하는 메인 실행 - class Calculate
		상금 총합 구하는 메소드 - class PrizeSum
			5등상을 통한 상금 - class FifthPrize
			4등상을 통한 상금 - class FourthPrize
			3등상을 통한 상금 - class ThirdPrize
			2등상을 통한 상금 - class SecondPrize 
			1등상을 통한 상금 - class FirstPrize
		총합을 통한 수익률 계산 - class YieldCirculate
