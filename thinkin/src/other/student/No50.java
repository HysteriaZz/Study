package other.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
在获取键盘输入时常常用到Scanner，但在连续使用Scanner的过程中会发生缓冲区不空，从而不会阻塞的问题
两种方法，循环里面new过，或者catch里面消耗掉，因为next或者nextLine函数会清空缓存
 */
public class No50 {

	public static void main(String[] args) throws IOException {
		ArrayList<Student> list = new ArrayList<>();

		System.out.println("请依次输入五个学生的数据");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 1; i++) {
			while (true) {
				try {
					//sc = new Scanner(System.in);
					System.out.println("请输入第" + (i + 1) + "位学生的学号，姓名：");
					int num = sc.nextInt();
					String name = sc.next();
					Student stu = new Student(num, name);
					list.add(stu);
					break;
				} catch (Exception e) {
					//sc.next();
					sc.nextLine();
					System.out.println("请按正确格式输入");
				}
			}

			System.out.println("请输入" + list.get(i).getName() + "的英语成绩");
			list.get(i).setEnglishScore(sc.nextDouble());
			System.out.println("请输入" + list.get(i).getName() + "的JAVA成绩");
			list.get(i).setJavaScore(sc.nextDouble());
			System.out.println("请输入" + list.get(i).getName() + "的数学成绩");
			list.get(i).setMathScore(sc.nextDouble());
			System.out.println(list.get(i).getName() + "的平均分为：" + list.get(i).average());

			list.get(i).save();
		}
		sc.close();

	}

}
