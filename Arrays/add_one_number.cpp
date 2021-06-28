#include "bits/stdc++.h"

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
    

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/max-non-negative-subarray/


vector<int> solve(vector<int> &A) {
    int n = A.size();
    auto beginIndex = A.end();
    for (auto i = A.begin() ; i != A.end() ; i++) {
        if ((*i) != 0) {
            beginIndex = i;
            break;
        }
    }
    if (beginIndex == A.end()) {
        return vector<int>(1, 1);
    }
    while(n--) {
        if (A[n] == 9) {
            A[n] = 0;
        } else {
            A[n]++;
            vector<int> ans;
            ans.assign(beginIndex, A.end());
            return ans;
        }
    }
    vector<int> ans;
    ans.assign(beginIndex, A.end());
    ans.insert(ans.begin(), 1);
    return ans;
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

