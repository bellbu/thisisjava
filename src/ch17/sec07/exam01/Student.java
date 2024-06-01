package ch17.sec07.exam01;

public class Student implements Comparable<Student>{
	private int score;
	
//	public Student(String name, int score) {
//		super();
//		this.name = name;
//		this.score = score;
//	}


//	public int getScore() {
//		return score;
//	}

//	public void setScore(int score) {
//		this.score = score;
//	}

	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}

}
