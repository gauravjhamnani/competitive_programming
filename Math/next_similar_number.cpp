#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/prime-sum/




string solve(string A) {
    int n = A.size();
    map<char, int> mp;
    int i;
    for (i = n - 1 ; i > 0 ; i--) {
        mp[A[i]]++;
        if (A[i] > A[i-1]) {
            break;
        }
    }
    if (i == 0) {
        return "-1";
    }
    auto it = mp.upper_bound(A[--i]);
    p(it->first);
    mp[it->first]--;
    mp[A[i]]++;
    string ans = "";
    for (auto itr = mp.begin() ; itr != mp.end() ; itr++) {
        for (int rep = 0 ; rep < itr->second ; rep++) {
            ans += itr->first;
        }
    }
    ans = it->first + ans;
    while(i--) {
        ans = A[i] + ans;
    }
    pm(mp);
    p(ans);
    return "";
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
	string a;cin >> a;
	// vector<string> A(n);
	// for (int i = 0; i < n ; i++) {
	// 	cin >> A[i];
	// }
	solve(a);
	return 0;
} 

