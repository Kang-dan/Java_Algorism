package homework6_2;

import java.util.Arrays;
/*
2.   영화(일반영화, 시리즈영화)리스트를 배열로 관리할 MovieManager 작성한다.
3.   MovieManager 클래스의 영화 제목을 검색하는 searchByTitle 메소드를 일치검색이 아닌 해당 제목을 일부 또는 전체로 포함하는 영화리스트를 반환하도록 수정한다.
4.   MovieManager 클래스에 일반 영화들을 반환하는 getMovies 메소드를 생성한다.
5.   MovieManager 클래스에 시리즈 영화들을 반환하는 getSeriesMovies 메소드를 생성한다.
6. MovieManager 클래스에 영화의 평균상영 시간을 반환하는 getRunningTimeAvg 메소드를 생성한다.
 */
/*
 add void
 getList Movie[]
 getMovies Movie[]
 getSeriesMovies Movie[]
 searchByTitle Movie[]
 getRunningTimeAvg double
 */
public class MovieManager {
	
	private final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	
	public void add(Movie movie) {
		if(size < MAX_SIZE) {
			movieList[size++] = movie;
		} else {
			System.out.println("추가할 수 있는 수가 넘었습니다. 등록이 불가합니다.");
		}
	}
	
	public Movie[] getList() {
		return Arrays.copyOfRange(movieList,0,size);
	}
	
	public Movie[] getMovies() {
		int count = 0;
		for(int i=0; i<this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				count++;
			}
		}
		
		if(count == 0) return null;
		
		Movie[] res = new Movie[count];
		
		for(int i=0, index=0; i<this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				res[index++] = movieList[i];
			}
		}
		return res;
	}
	
	public SeriesMovie[] getSeriesMovies() {
		int count = 0;
		
		for(int i=0; i<this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				count++;
			}
		}
		
		if(count == 0) {
			return null;
		}
		SeriesMovie[] res = new SeriesMovie[count];
		
		for(int i=0, index=0; i<this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				res[index++] = (SeriesMovie)movieList[i];
			}
		}
		return res;
	}
	
	public Movie[] searchByTitle(String title) {
		int count = 0;
		
		for(int i=0; i<this.size; i++) {
			//영화제목 검색 후 해당 제목을 일부 또는 전체 포함리스트 반환 
			if(movieList[i].getTitle().equals(title)) {
				count++;
			}
		}
		if(count == 0) return null;
		
		Movie[] res = new Movie[count];
		
		for(int i=0, index =0; i<this.size; i++) {
			if(movieList[i].getTitle().equals(title)) {
				res[index++] = movieList[i];
			}
		}
		return res;
	}
	
	//평균상영시간 반환
	public double getRunningTimeAvg() {
		int sum=0;
		for(int i=0; i<this.size; i++) {
			sum += movieList[i].getRunningTime();
		}
		
		return sum/this.size;
	}
	
}
