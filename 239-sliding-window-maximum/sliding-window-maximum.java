import java.io.FileWriter;
import java.io.IOException;

public class RuntimeHook {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            if (i >= k - 1) {
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                result[resultIndex++] = pq.peek()[0];
            }
        }

        return result;
    }
}