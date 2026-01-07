class Solution {
    private static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int as = toDayOfYear(arriveAlice);
        int ae = toDayOfYear(leaveAlice);
        int bs = toDayOfYear(arriveBob);
        int be = toDayOfYear(leaveBob);
        int s = Math.max(as, bs);
        int e = Math.min(ae, be);
        return Math.max(0, e - s + 1);
    }
    private int toDayOfYear(String mmdd) {
        int m = Integer.parseInt(mmdd.substring(0, 2));
        int d = Integer.parseInt(mmdd.substring(3, 5));
        for(int i = 0; i < m - 1 ; i ++){
            d+=DAYS_IN_MONTH[i];
        }
        return d;
    }
}
