package other.student;

import java.io.FileWriter;
import java.io.IOException;


public class Student {

	private int number;
	private String name;
	private Double englishScore=0.0;
	private Double javaScore=0.0;
	private Double mathScore=0.0;
	private Double average=0.0;
	public Student(){
		
	}
	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
		average();
		
	}
	public void save() throws IOException {
		FileWriter fw = new FileWriter("stud.txt",true);
		fw.write(String.valueOf(number));
		fw.write(name);
		fw.write(englishScore.toString());
		fw.write(javaScore.toString());
		fw.write(mathScore.toString());
		fw.write(average.toString());
		fw.write("\n");
		fw.close();
	}
	public double average() {
		this.average = (this.englishScore+this.javaScore+this.mathScore)/3;
		return average;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(double d) {
		this.englishScore = d;
	}
	public double getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(double javaScore) {
		this.javaScore = javaScore;
	}
	public double getMathScore() {
		return mathScore;
	}
	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}
}
