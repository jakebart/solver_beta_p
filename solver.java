//V 0.0.1
// Word search solver because I have beef from the 7th grade biology class
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
		//remember to undo the hard code in the loop
		//Diagonal
		/*for (int i = 0; i < 7; i++) {
			String line_ = "";
			for (int j = 0; j < 7; j++) {
				//difference is in the int variables for substring
				line_ += puzzle_line_h[j].substring(0 + j, 1 + j);
			}
			//will need new array
			puzzle_line_v[i] = line_;
		}*/
		//Loop for creating strings for vertical lines, may need to change if puzzle isn't square
		for (int i = 0; i < h_len; i++) {
			v_len++;
			String line_ = "";
			for (int j = 0; j < h_len; j++) {
				line_ += puzzle_h.get(j).substring(i, i+1);
			}
			puzzle_v.add(i, line_);
		}
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