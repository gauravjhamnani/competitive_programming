#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define ps(a) for (auto i = a.begin(); i != a.end() ; i++) cout << *i << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/next-similar-number/




string solve(string A) {
    int n = A.size();
    multiset<char> mp;int i;
    for (i = n - 1 ; i > 0 ; i--) {
        mp.insert(A[i]);
        if (A[i] > A[i-1]) {
            break;
        }
    }
    if (i == 0) {
        return "-1";
    }
    auto itr = upper_bound(mp.begin(), mp.end(), A[--i]);
    char rem = *itr;
    mp.erase(itr);
    mp.insert(A[i]);
    ps(mp);
    string ans = "";
    for (auto el : mp) {
        ans += el;
    }
    p(rem);
    ans = rem + ans;
    while (i--) {
        ans = A[i] + ans;
    }
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

