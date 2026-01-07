class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for(String cmd: commands){
            switch(cmd){
                case "UP":
                    x--;
                    break;
                case "DOWN":
                    x++;
                    break;
                case "RIGHT":
                    y++;
                    break;
                case "LEFT":
                    y--;
                    break;
            }
        }
        return x * n + y;
    }
}
