#include "bits/stdc++.h"

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
    

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/perfect-peak-of-array/


int perfectPeak(vector<int> &A) {
    int n = A.size();
    vector<int> leftGreatest(n, 0);
    leftGreatest[0] = A[0];
    for (int i = 1 ; i < n ; i++) {
        if (A[i] > leftGreatest[i-1]) {
             leftGreatest[i] = A[i];
        } else {
            leftGreatest[i] = leftGreatest[i-1];
        }
    }
    vector<int> rightSmallest(n, 0);
    rightSmallest[n-1] = A[n-1];
    for (int i = n - 2 ; i >= 0 ; i--) {
        if (A[i] < rightSmallest[i+1]) {
            rightSmallest[i] = A[i];
        } else {
            rightSmallest[i] = rightSmallest[i+1];
        }
    }
    for (int i = 1 ; i < n - 1 ; i++) {
        if ((leftGreatest[i-1] < A[i]) && (A[i] < rightSmallest[i+1])) {
            return 1;
        }
    }
    return 0;
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
	p(perfectPeak(A));
	return 0;
} 

