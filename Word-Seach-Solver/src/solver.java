//V 0.0.1
// Word search solver because I have beef from the 7th grade biology class
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class solver {

	public static void main(String[] args) throws FileNotFoundException {
		/*Notes:
		 List will need to become array for compatibility
		 Will need to change the appending in the for loops 
		 */
		
		//Vars
		String[] puzzle_line_h = new String [] {"", "", "", "", "", "", "", "", ""};
		String[] puzzle_line_v = new String [] {"", "", "", "", "", "", "", "", ""};
		String[] puzzle_ans = new String [] {"", "", "", "", "", "", "", "", "", "", ""};

		//open puzzle
		File puzzle_file = new File("C:\\Users\\J4k3\\Documents\\Word_Search.txt");
		Scanner puzzle = new Scanner(puzzle_file);
		File puzzle_ans_file = new File("C:\\Users\\J4k3\\Documents\\Word_Search_Answers.txt");
		Scanner ans = new Scanner(puzzle_ans_file);
		//Find lines of puzzle, 7 is there to test (change to user input later)
		//Don't put algorithm to solve here (nested loop results in compile error 9/18)
		for (int i = 0; i < 8; i ++) {
			puzzle_line_h[i] = puzzle.next();
			//puzzle_line_v[i] = puzzle_line[i].charAt();
		}
		//remember to undo the hard code in the loop
		/*for (int i = 0; i < 7; i++) {
			String line_ = "";
			for (int j = 0; j < 7; j++) {
				line_ += puzzle_line_h[j].substring(0 + j, 1 + j);
			}
			puzzle_line_v[i] = line_;
		}
		System.out.println(puzzle_line_v[0]);*/
		for (int i = 0; i < 8; i++) {
			String line_ = "";
			for (int j = 0; j < 8; j++) {
				line_ += puzzle_line_h[j].substring(i, i+1);
			}
			puzzle_line_v[i] = line_;
		}

		//Reads from answer txt file (int i will be user input later)
		for (int j = 0; j < 9; j++) {
			puzzle_ans[j] = ans.next();
		}
		//Write case for solution at 0
		for (int i = 0; i < puzzle_line_h.length; i++) {
			String str_com = puzzle_line_h[i];
			System.out.println(str_com);
			for (int l = 0; l < puzzle_ans.length; l++) {
				if(str_com.indexOf(puzzle_ans[l]) != -1 && str_com.indexOf(puzzle_ans[l]) != 0) {
					System.out.println("Solution found at: " + str_com.indexOf(puzzle_ans[l]) + " for " + puzzle_ans[l]);
				}
				else {
					System.out.print("");
				}
			}
		}
		
		for (int i = 0; i < puzzle_line_v.length; i++) {
			String str_com = puzzle_line_v[i];
			System.out.println(str_com);
			for (int l = 0; l < puzzle_ans.length; l++) {
				
				if(str_com.indexOf(puzzle_ans[l]) >= 0 /*&& str_com.indexOf(puzzle_ans[l]) != 0*/) {
					if (str_com.indexOf(puzzle_ans[l]) == 0) {
						if (puzzle_ans[l].length() != 0) {
							System.out.println("Solution found at: " + str_com.indexOf(puzzle_ans[l]) + " for " + puzzle_ans[l]);
						}
						else {
							System.out.print("");
						}
					}
					
					
				}
				else if(str_com.indexOf(puzzle_ans[l]) != 0 && str_com.indexOf(puzzle_ans[l]) != -1) {
					System.out.println("Solution found at: " + str_com.indexOf(puzzle_ans[l]) + " for " + puzzle_ans[l]);
				}
				else {
					System.out.print("");
				}
			}
		}
				
		
		puzzle.close();
		ans.close();
	}
	}


