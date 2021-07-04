#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/prime-sum/




vector<int> primesum(int A) {
    vector<bool> primes(A+1, true);    
    for (int i = 2 ; i <= A ; i++) {
        if (i*i <= A && primes[i]) {
            for (int j = i*i ; j <= A ; j += i) {
                primes[j] = false;
            }
        }
    }
    int i = 2, j = A;
    vector<int> ans;
    while(i < j) {
        if (!primes[i]) {
            i++;
        } else if (!primes[j]) {
            j--;
        } else {
            if ((i + j) == A) {
                ans.push_back(i);
                ans.push_back(j);
                return ans;
            } else if ((i + j) < A) {
                i++;
            } else {
                j--;
            }
        }
    }

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
	int a;cin >> a;
	// vector<string> A(n);
	// for (int i = 0; i < n ; i++) {
	// 	cin >> A[i];
	// }
	pv(primesum(a));
	return 0;
} 

