#include "bits/stdc++.h"

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
    

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/max-non-negative-subarray/


struct Value {
    long long sum = 0;
    int index = -1;
    int count = 0;
};
vector<int> solve(vector<int> &A) {
    int n = A.size();
    long long count = 0, prevSum = 0, index = -1;
    Value ans;
    for (int i = 0 ; i <= n ; i++){
        if ((i==n) || A[i] < 0) {
            if ((ans.sum < prevSum) || ((ans.sum == prevSum) && ans.count < count) || ((ans.sum == prevSum) && ans.count == count && ans.index < index)) {
                ans.sum = prevSum;
                ans.count = count;
                ans.index = index;
            }
            prevSum = 0;
            index = -1;
            count = 0;
        } else {
            if (index == -1) {
                index = i;
            }
            prevSum += A[i];
            count++;
        }
    }
    vector<int> sol(ans.count, 0);
    for (int i = 0 ; i < ans.count ; i++) {
        sol[i] = A[ans.index + i];
    }
    return sol;
}


int main() {
	ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	// int t;
	// cin >> t;
	// while (t--) {
	// 	int n;
	// 	cin >> n;
	// 	p(n);
	// }
	int n;cin >> n;
	vector<int> A(n, 0);
	for (int i = 0; i < n ; i++) {
		cin >> A[i];
	}
	pv(solve(A));
	return 0;
} 

