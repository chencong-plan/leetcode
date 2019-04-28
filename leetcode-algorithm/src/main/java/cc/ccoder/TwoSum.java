package cc.ccoder;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cc.ccoder
 * @since 2019/4/28 19:47
 */

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = {7, 2, 11, 15};
        int[] nums = {2, 4, 5};
        int target = 6;
//        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
//        System.out.println(Arrays.toString(twoSum.twoSum1(nums, target)));
        System.out.println(Arrays.toString(twoSum.twoSum2(nums, target)));
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == target - temp) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int index;
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        int diff;
        for (int i = 1; i < nums.length; i++) {
            diff = target - nums[i];
            //i=0时索引无效,所以单独处理
            if (diff == nums[0]) {
                return new int[]{0, i};
            }
            index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[]{indexArrays[index], i};
            }
            indexArrays[nums[i] & indexArrayMax] = i;
        }
        return new int[2];
    }

    /**
     * map[num[i],i] => 逐步将数据放入map ，判断map中是否存在当前 target-num[i]的值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

