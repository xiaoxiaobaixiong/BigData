package 田伟宏;

import java.util.Arrays;
import java.util.Scanner;

public class 输入不固定长度数组 {
    public static void main(String args[]) {
        System.out.print("请输入数组(空格隔开)：");
        Scanner sc = new Scanner(System.in);
        String[] nums;
        nums = sc.nextLine().split(" ");
        int num[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = Integer.valueOf(nums[i]);
        }
        sc.close();
        System.out.print(Arrays.toString(num));
    }
}
