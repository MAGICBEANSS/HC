package prc.hc.sessiontests.firsttest;

import java.util.ArrayList;

public class Sort012 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(2);
        list.add(0);
        list.add(1);
        sortBalls(list);
        System.out.println(list);
    }

    static void  sortBallsp(ArrayList<Integer> nums) {
            int i=0,j=0;
            int k=nums.size()-1;
            while (i<=k) {
                if(nums.get(i)==2) {
                    int no = nums.get(i);
                    nums.set(i,nums.get(k));
                    nums.set(k,no);
                    k--;
                }
                if(nums.get(i)==1) {
                   i++;
                }
                if(nums.get(i)==0) {
                    int no = nums.get(i);
                    nums.set(i,nums.get(j));
                    nums.set(j,no);
                    i++;j++;
                }
            }
    }
        static void  sortBalls(ArrayList<Integer> nums) {
        int high = nums.size()-1;
        int low = 0;
        int mid = 0;
        while (mid<=high) {
            if(nums.get(mid)==0) {
                int no = nums.get(mid);
                nums.set(mid,nums.get(low));
                nums.set(low,no);
                mid++;
                low++;
            }
            else if(nums.get(mid)==1) {
                mid++;
            }
            else if(nums.get(mid)==2){
                int no = nums.get(mid);
                nums.set(mid,nums.get(high));
                nums.set(high,no);
                high--;
            }
        }
    }
}
