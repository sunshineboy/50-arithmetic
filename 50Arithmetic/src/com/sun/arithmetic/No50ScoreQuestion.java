package com.sun.arithmetic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 
 * @author sunshine_boy
 * @version 1.0 Create at 2013-11-12
 */
public class No50ScoreQuestion {

	/**
	 * @param args
	 * @author sunshine_boy 有五个学生，每个学生有3门课的成绩， 从键盘输入以上数据（包括学生号，姓名，三门课成绩），
	 *         计算出平均成绩，把原有的数据和计算出的平均分数存放在磁盘文件 "stud "中。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 接受输入的数据
		Scanner scanner = new Scanner(System.in);
		String[][] data = new String[5][6];
		for (int i = 1; i < 4; i++) {
			System.out.print("请输入第" + i + "个学生的学号：");
			data[i - 1][0] = scanner.nextLine();
			System.out.print("请输入第" + i + "个学生的姓名：");
			data[i - 1][1] = scanner.nextLine();
			for (int j = 1; j < 4; j++) {
				System.out.print("请输入该学生的第" + j + "门课的成绩：");
				data[i - 1][j + 1] = scanner.nextLine();
			}
			System.out.println();
		}
		scanner.close();
		// 计算成绩
		float avg;
		int sum;
		for (int i = 0; i < 3; i++) {
			sum = 0;
			for (int j = 2; j < 5; j++) {
				sum = sum + Integer.valueOf(data[i][j]);
			}
			avg = sum / 3;
			data[i][5] = String.valueOf(avg);
		}
		// 写入文件
		String line;
		try {
			File file = new File("F:\\stud");
			if (file.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在，正在创建文件");
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					line = data[i][j] + "\r\n";
					writer.write(line);
				}
			}
			writer.close();
			System.out.println("数据已写入F盘文件stud中！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
