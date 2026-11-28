class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        int n = apple.length;
        for(int i = 0; i < n; i++)
        {
            total+=apple[i];
        }
        int m = capacity.length;
        int ans = 0;
        for(int i = m-1; i >= 0; i--)
        {
            if(total > 0)
            {
                total-=capacity[i];
                ans++;
            }
        }
        return ans;
    }
}