//V 0.0.3
// Word search solver because I have beef from the 7th grade biology class
//Currently only works if word search is square...

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class solver {

	public static void main(String[] args) throws FileNotFoundException {
		/*Notes:
		 */
		//Vars
		int h_len = 0, v_len = 0, a_len = 0;
		ArrayList<String> puzzle_h = new ArrayList<String>(h_len);
		ArrayList<String> puzzle_v = new ArrayList<String>(v_len);
		
		ArrayList<String> puzzle_ans = new ArrayList<String>(a_len);

		//open puzzle
		File puzzle_file = new File("C:\\Users\\J4k3\\Documents\\Word_Search.txt");
		Scanner puzzle = new Scanner(puzzle_file);
		File puzzle_ans_file = new File("C:\\Users\\J4k3\\Documents\\Word_Search_Answers.txt");
		Scanner ans = new Scanner(puzzle_ans_file);
		//Enter lines as string into list
		while(puzzle.hasNext()) {
			h_len++;
			puzzle_h.add(puzzle.next());
		}
		//Loop for creating strings for vertical lines, may need to change if puzzle isn't square
		for (int i = 0; i < h_len; i++) {
			v_len++;
			String line_ = "";
			for (int j = 0; j < h_len; j++) {
				line_ += puzzle_h.get(j).substring(i, i+1);
			}
			puzzle_v.add(i, line_);
		}
		//Diagonal
		//need second loop for left side 
		ArrayList<String> puzzle_d = new ArrayList<String>(((v_len-1) * 4) - 2); //Linear function
		int c = 0;
		for (int i = 0; i < v_len - 1; i++) {
			String line = "";
			if (i == 0) {
				for (int j = i; j < v_len - i; j++) {				
					line += puzzle_h.get(j).substring(j, j+1);
				}
			}
			else {
				for (int j = 0; j < v_len - i; j++) {				
					line += puzzle_h.get(j+i).substring(j, j+1);
				}
			}
			puzzle_d.add(i, line);
			c++;
		}
		for (int i = 1; i < v_len; i++) {
			String line = " ";
			for (int j = 0; j < v_len - i; j++) {				
				line += puzzle_v.get(j+i).substring(j, j+1);
			}
			puzzle_d.add(i + (c - 1), line);
		}
		//System.out.println(puzzle_d);
					
		//Reads from answer txt file, use num of lines as int for iterating loop
		while (ans.hasNext()) {
			puzzle_ans.add(a_len, ans.next());
			a_len++;
		}
		//horizontal checks
		for (int i = 0; i < puzzle_h.size(); i++) {
			String str_com = puzzle_h.get(i);
			System.out.println(str_com);
			for (int l = 0; l < puzzle_ans.size(); l++) {
				String ans_string = puzzle_ans.get(l);
				retrive(str_com, ans_string);
			}
		}
		System.out.println("");
		//vertical checks
		for (int i = 0; i < puzzle_v.size(); i++) {
			String str_com = puzzle_v.get(i);
			System.out.println(str_com);
			for (int l = 0; l < puzzle_ans.size(); l++) {
				String ans_string = puzzle_ans.get(l);
				retrive(str_com, ans_string);
			}
		}
		System.out.println("");
		//Diagonal checks
		for (int i = 0; i < puzzle_d.size(); i++) {
			String str_com = puzzle_d.get(i);
			System.out.println(str_com);
			for (int l = 0; l < puzzle_ans.size(); l++) {
				String ans_string = puzzle_ans.get(l);
				retrive(str_com, ans_string);
			}
		}
		
		puzzle.close();
		ans.close();
	}
	public static String retrive(String str_com, String ans_string) {
		String solution = "";
		if (str_com.indexOf(ans_string) == 0 && ans_string.length() != 0) {
			System.out.println("Solution found at: " + str_com.indexOf(ans_string) + " for " + ans_string);
		}
		else if(str_com.indexOf(ans_string) != -1 && str_com.indexOf(ans_string) != 0) {
			System.out.println("Solution found at: " + str_com.indexOf(ans_string) + " for " + ans_string);
		}
		else {
			System.out.print("");
		}
		return solution;
	}
}