//Question:118
//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
// 
//
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]

package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if (numRows == 0) return res;
		
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		res.add(firstRow);
		if (numRows == 1) return res;
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> preRow = res.get(i - 1);
			ArrayList<Integer> newRow = new ArrayList<>();
			newRow.add(1);
			for (int j = 0; j < i -1; j++) {
				newRow.add(preRow.get(j) + preRow.get(j+1));
			}
			newRow.add(1);
			res.add(newRow);
		}
		return res;
		
	}
}
