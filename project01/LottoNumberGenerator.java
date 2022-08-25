package project01;

import java.util.Scanner;

//로또 번호 생성기
//Math.Random 배열
//숫자 6개 중복 X
//Scanner 숫자 비교, .length 활용해서 for문 사용

// 숫자 6개 순서 상관없이 입력받는다.
// 만약 중복 숫자 있다면 중복됐습니다. ‘다시 입력하세요’ 출력
// 그 후 랜덤 6개 숫자 배열에 입력, 중복 있다면 다시 뽑기
// 2개 배열 숫자 순서 맞추기
// 서로 비교해서 몇 개 맞았는지 출력

public class LottoNumberGenerator {
	public static void main(String[] args) {
		int[] com_lottol_number = new int[] { 0, 0, 0, 0, 0, 0, }; // 컴퓨터가 출력하는 랜덤 로또 번호 6개
		int[] user_lotto_number = new int[] { 0, 0, 0, 0, 0, 0, }; // 사람이 입력하는 로또 번호 6개
		int sort_num = 0; // 선택 정렬할 때 값을 바꿔주기 위한 변수
		int count = 0; // 사람이 입력한 번호와 랜덤 번호 중에 같은 번호 개수
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------------------------------");
		System.out.println("          Lotto Program");
		System.out.println("------------------------------------\n");
		System.out.println("(로또 번호를 6개 입력해주세요.\n컴퓨터가 뽑은 로또 번호와 비교해서 알려드립니다.)\n");
		
		// 사람이 입력한 번호를 user_lotto_number[] 배열에 저장해 주기 위한 반복문
		for(int i = 0; i <= (user_lotto_number.length - 1); ++i) {
			System.out.print("숫자 " + (i+1) + "번 > ");
			user_lotto_number[i] = scanner.nextInt();
			
			for(int j = 0; j <= i; ++j) {	//같은 숫자 입력 방지를 위한 반복문
				if(j == i) {	// 자신은 비교하지 않도록 작성
					
				} else {
					if(user_lotto_number[i] == user_lotto_number[j]) {
						System.out.println("중복된 숫자를 입력하셨습니다. 다시 입력하세요.");
						--i;
					}
				}
			}
			
			System.out.println();
		}
		
		// 컴퓨터가 생성한 랜덤 번호를 com_lottol_number[] 배열에 저장해 주기 위한 반복문
		for(int i = 0; i <= (com_lottol_number.length - 1); ++i) {
			com_lottol_number[i] = (int)(Math.random()*45) + 1;
			
			for(int j = 0; j <= i; ++j) {	//같은 숫자 출력 방지를 위한 반복문
				if(j == i) {	// 자신은 비교하지 않도록 작성
					
				} else {
					if(com_lottol_number[i] == com_lottol_number[j]) {
						--i;
					}
				}
				
			}
		}
		
		// 사람이 입력한 로또 번호를 선택 정렬하기 위한 반복문
		for(int i = 0; i < (user_lotto_number.length - 1); ++i) {
			int tmp = i;
			for(int j = i + 1; j < user_lotto_number.length; ++j) {
				if(user_lotto_number[tmp] >= user_lotto_number[j]) {
					tmp = j;
				}
			}
			sort_num = user_lotto_number[i];
			user_lotto_number[i] = user_lotto_number[tmp];
			user_lotto_number[tmp] = sort_num;
		}
		
		// 프로그램이 랜덤으로 뽑은 로또 번호를 선택 정렬하기 위한 반복문
		for(int i = 0; i < (com_lottol_number.length - 1); ++i) {
			int tmp = i;
			for(int j = i + 1; j < com_lottol_number.length; ++j) {
				if(com_lottol_number[tmp] >= com_lottol_number[j]) {
					tmp = j;
				}
			}
			sort_num = com_lottol_number[i];
			com_lottol_number[i] = com_lottol_number[tmp];
			com_lottol_number[tmp] = sort_num;
		}
		
		// 사람이 입력한 번호와 랜덤 번호의 같은 번호 개수를 구하기 위한 반복문
		for(int i = 0; i <= (user_lotto_number.length - 1); i++) {
			for(int j = 0; j <= (com_lottol_number.length - 1); j++) {
				if(user_lotto_number[i] == com_lottol_number[j]) {
					++count;
				}
			}
		}
		
		System.out.print("입력하신 로또 번호 : [ ");
		for(int i = 0; i <= 4; ++i) {
			System.out.print(user_lotto_number[i] + ", ");
		}
		System.out.println(user_lotto_number[5] + " ]");
		
		System.out.print("프로그램 로또 번호 : [ ");
		for(int i = 0; i <= 4; ++i) {
			System.out.print(com_lottol_number[i] + ", ");
		}
		System.out.println(com_lottol_number[5] + " ]");
		
		System.out.println("\n입력하신 로또 번호와 " + count + "개 일치합니다.");
		System.out.println("\n프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
		
		scanner.close();
	}
}