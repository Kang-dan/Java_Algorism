//문자열로 입력받고 -> 배열로 옮기기 String[] arr = num.split("");
/* 1289. 원재의 메모리 복구하기
원재가 컴퓨터를 만지다가 실수를 저지르고 말았다. 메모리가 초기화된 것이다.
다행히 원래 메모리가 무슨 값이었는지 알고 있었던 원재는 바로 원래 값으로 되돌리려고 했으나 메모리 값을 바꿀 때 또 문제가 생겼다.
메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것이다.
예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.
원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산해보자.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 메모리의 원래 값이 주어진다.
메모리의 길이는 1이상 50이하이다.

[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
초기값(모든bit가 0)에서 원래 값으로 복구하기 위한 최소 수정 횟수를 출력한다.
 */

package algorism_java;

import java.util.*;
import java.io.*;
//import java.util.Arrays; //배열 객체를 사용할 때
//Array.fill(num,1); 배열 전체를 1로 채울 
//Array.sort(num); 배열을 정렬할 때
//Array.sort(num); 배열이 정렬되어 있다면 이진검색을 사용해 배열 내 값 찾을 때
//int index = Arrays.binarySearch(num, 5) // 배열 내에서 5값을 찾아 그 인덱스를 반

public class java_SWEA_1289 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
//			String num = sc.next();
//			String[] arr = num.split("");
			String num = sc.next(); //문자열 입력받
			String[] arr = num.split(""); //문자열을 배열로 옮기
			
			int count = 0; //선언만 하면 0으로 초기화되는지 확인하기!
			String flag = null;
			
			for(int i=0; i<arr.length; i++){
				if(count==0 && arr[i].equals("1")){
					count++;
					flag=arr[i];
				}
				if(count!=0 && !(arr[i].equals(flag))) {
					count++;
					flag = arr[i];
				}
			}
			System.out.println("#"+test_case+" "+count);
			
		}
	}
}