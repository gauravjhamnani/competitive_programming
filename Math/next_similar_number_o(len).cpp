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
    int n = A.size(), i = 0;
    for (i = n - 1 ; i > 0 ; i--) {
        if (A[i] > A[i-1]) {
            break;
        }
    }
    if (i == 0) {
        return "-1";
    }
    i--;
    auto ubItr = A.rbegin();
    for (; ubItr != A.rend() ; ubItr++) {
        if (*ubItr > A[i]) {
            swap(A[i], *ubItr);
            break;
        }
    }
    reverse(A.begin() + i + 1, A.end());
    return A;
}


// string solve(string A) {
//     int n = A.size();
//     vector<char> v;int i;
//     for (i = n - 1 ; i > 0 ; i--) {
//         v.push_back(A[i]);
//         if (A[i] > A[i-1]) {
//             break;
//         }
//     }
//     if (i == 0) {
//         return "-1";
//     }
//     i--;
//     auto j = upper_bound(v.begin(), v.end(), A[i]);
//     char toAdd = *j;
//     v.erase(j);
//     v.insert(j, A[i]);
//     string ans = "";
//     for (int lp = 0 ; lp < v.size() ; lp++) {
//         ans += v[lp]; 
//     }
//     ans = toAdd + ans;
//     while (i--) {
//         ans = A[i] + ans;
//     }
//     return ans;
// }





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
	p(solve(a));
	return 0;
} 

