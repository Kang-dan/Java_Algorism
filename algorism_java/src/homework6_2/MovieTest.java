package homework6_2;

import java.util.Arrays;

public class MovieTest {

	public static void main(String[] args) {
		Movie movie1 = new Movie();
		movie1.setId(1);
		movie1.setTitle("movie1");
		movie1.setDirector("강감독");
		movie1.setGenre("액션");
		movie1.setRunningTime(1);

		Movie movie2 = new Movie(2, "파이팅!", "김작가", "로맨스", 2);
		SeriesMovie smovie3 = new SeriesMovie(3, "smovie3", "최감독" , "힐링", 3, 10, "에피소드");
		
		MovieManager um = new MovieManager();
		
		um.add(movie1);
		um.add(movie2);
		um.add(smovie3);
		
		// 영화제목 검색해서 해당제목 전체 포함하는 영화 리스트 반환
		System.out.println("******'파이팅!' 영화 제목 일치하는 영화리스트*****");
		Movie[] movietitle = um.searchByTitle("파이팅!"); //수정!
		for (Movie movie : movietitle) {
		    System.out.println(movie.toString());
		}
		System.out.println();
		// System.out.println(um.searchByName("김")); //이렇게하면 [Lcom.ssafy.hw.step2.User;@15db9742 이렇게 나옴.
		
		// 일반 사용자 리스트만 가져와서 toString 으로 출력
		System.out.println("*****시리즈 영화 리스트*****");
		Movie[] movieList = um.getSeriesMovies(); //수정!
		for (Movie movie : movieList) {
			System.out.println(movie.toString());
		}
		System.out.println();
		//System.out.println(um.getList().toString()); //이렇게하면 [Lcom.ssafy.hw.step2.User;@15db9742 이렇게 나옴.

		// 평균 상영시간
		System.out.println("*****영화 평균 상영시간*****");
		System.out.println(um.getRunningTimeAvg()); //수정! um.getAgeAvg()
		
	}

}