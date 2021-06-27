#include "bits/stdc++.h"

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
    

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/maximum-sum-triplet/


int solve(vector<int> &A) {
    int n = A.size();
    if (n < 3) {
        return 0;
    }
    vector<int> maxOne(n, -1);
    maxOne[n-1] = A[n-1];
    for (int j = n - 2 ; j >= 0 ; j--) {
        maxOne[j] = max(A[j], maxOne[j + 1]);
    }
    pv(maxOne);
    vector<int> maxTwo(n, -1);
    for (int j = n - 2 ; j >= 0 ; j--) {
        if (maxOne[j+1] > A[j]) {
            maxTwo[j] = A[j] + maxOne[j+1];
        }
    }
    pv(maxTwo);
    int answer = 0;
    map<int, int> mp;
    for (int i = 0 ; i < n - 2 ; i++) {
        if (mp.find(A[i]) == mp.end()) {
            mp.insert(pair<int, int>(A[i], 1));
        } else {
            mp[A[i]]++;
        }
    }
    pm(mp);
    for (int j = n - 3 ; j >= 0 ; j--) {
    	if (maxTwo[j+1] != -1) {
	        auto it = mp.lower_bound(A[j+1]);
	        if (it != mp.begin()) {
	        	answer = max(answer, (--it)->first + maxTwo[j+1]);
	        }
    	}
        if (mp[A[j]] == 1) {
            mp.erase(mp.lower_bound(A[j]));
        } else {
            mp[A[j]]--;
        }
        p(answer);
    } 
    return answer;
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

