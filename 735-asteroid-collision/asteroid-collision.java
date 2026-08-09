import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } 
            else {

                while (!st.empty() && st.peek() > 0 &&
                       st.peek() < -asteroids[i]) {
                    st.pop();
                }

                if (!st.empty() && st.peek() == -asteroids[i]) {
                    st.pop();
                }
                else if (st.empty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length-1 ; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}