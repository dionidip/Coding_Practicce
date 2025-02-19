package DP;

import java.util.*;
import java.io.*;

public class BOJ11660 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    /**
     * dp[i][j]에는 (0,0)에서부터 (i,j)까지 더한 값을 넣는다
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j]
     */

    int[][] map = new int[n+1][n+1];
    int[][] dp = new int[n+1][n+1];
    for (int i = 1; i < n+1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n+1; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
      }
    }
    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      System.out.println(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]);
    }
  }
}
