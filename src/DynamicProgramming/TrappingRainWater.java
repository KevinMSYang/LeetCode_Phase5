//Question:42
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//
//
//Example 1:
//
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//Example 2:
//
//Input: height = [4,2,0,3,2,5]
//Output: 9

package DynamicProgramming;

public class TrappingRainWater {
	public int trap(int[] height) {
		int n = height.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				leftMax[i] = height[i];
			}
			else {
				leftMax[i] = Math.max(leftMax[i-1], height[i]);
			}
		}
		
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				rightMax[i] = height[i];
			}
			else {
				rightMax[i] = Math.max(rightMax[i+1], height[i]);
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.min(rightMax[i], leftMax[i]) - height[i];
		}
		return sum;
	}
}
