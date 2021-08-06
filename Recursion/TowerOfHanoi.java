class TowerOfHanoi {

    public long toh(int N, int from, int to, int aux) {
        if (N == 0) {
            return 0;
        }
        long cnt1 = toh(N-1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        long cnt2 = toh(N-1, aux, to, from);
        return cnt1 + cnt2 + 1;
    }
}