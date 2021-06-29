#include "bits/stdc++.h"

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
    

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/add-one-to-number/


int solve(vector<int> &B) {
    int n = B.size();
    vector<int> oneThird;
    vector<int> twoThird;
    long long sum = 0;
    for (int i : B) {
        sum += i;
    }
    long long currSum = 0;
    for (int i = 0 ; i < B.size() - 1 ; i++) {
        currSum += B[i];
        if ((3 * currSum) == sum) {
            oneThird.push_back(i);
        } 
        if ((3 * currSum) == (2 * sum)) {
            twoThird.push_back(i);
        }
    }
    pv(oneThird);
    pv(twoThird);
    int oneIndex = 0, twoIndex = 0;
    int oneSize = oneThird.size();
    int twoSize = twoThird.size();
    long count = 0;
    while (oneIndex < oneSize && twoIndex < twoSize) {
        while(twoIndex < twoSize && oneThird[oneIndex] >= twoThird[twoIndex]) {
            twoIndex++;
        }
        count += twoSize - twoIndex;
        oneIndex++;
    }
    return count;
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
	p(solve(A));
	return 0;
} 

