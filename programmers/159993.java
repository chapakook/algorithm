import java.util.*;

class Solution {
  public int solution(String[] maps) {
    int n = maps.length;
    int m = maps[0].length();

    int[] start = { 0, 0 };
    int[] lever = { 0, 0 };
    int[] exit = { 0, 0 };

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = maps[i].charAt(j);
        if (c == 'S') {
          start[0] = i;
          start[1] = j;
        } else if (c == 'L') {
          lever[0] = i;
          lever[1] = j;
        } else if (c == 'E') {
          exit[0] = i;
          exit[1] = j;
        }
      }
    }

    int toLever = bfs(maps, start, lever);
    int toExit = bfs(maps, lever, exit);
    if (toLever == -1 || toExit == -1)
      return -1;
    return toLever + toExit;
  }

  private int bfs(String[] maps, int[] start, int[] target) {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int n = maps.length;
    int m = maps[0].length();

    Queue<int[]> queue = new ArrayDeque<>();
    int[][] dist = new int[n][m];
    dist[start[0]][start[1]] = 1;
    queue.offer(new int[] { start[0], start[1] });
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];
      if (x == target[0] && y == target[1])
        return dist[x][y] - 1;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (dist[nx][ny] != 0)
          continue;
        if (maps[nx].charAt(ny) == 'X')
          continue;
        dist[nx][ny] = dist[x][y] + 1;
        queue.offer(new int[] { nx, ny });
      }
    }
    return -1;
  }
}
