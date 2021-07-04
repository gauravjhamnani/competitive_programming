#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define ps(a) for (auto i = a.begin(); i != a.end() ; i++) cout << *i << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/next-similar-number/

long long factMod(unsigned int n, unsigned int m) {
    unsigned long long ans = 1;
    while(n > 0) {
        ans = ans * n;
        ans = ans % m;
        n--;
    }
    return ans;
}

long long moduleexp(unsigned int x, unsigned int y, unsigned int m) {
    if (x == 0 || y == 0) {
        return 1;
    }
    long long halfMul = moduleexp(x, y/2, m) % m;
    halfMul = halfMul * halfMul;
    halfMul = halfMul % m;
    if ((y % 2) == 1) {
        halfMul = halfMul * x;
        halfMul = halfMul % m;
    }
    return halfMul;
}

int solve(int A, vector<int> &B) {
    int n = B.size();
    unsigned int m = 1000000007;
    sort(B.begin(), B.end());
    vector<int> segLen;
    for (int i = 1 ; i < n ; i++) {
        if (B[i] - B[i-1] > 1)
        segLen.push_back(B[i] - B[i-1] - 1);
    }
    pv(segLen);
    unsigned int first = B[0] - 1;
    unsigned int last = A - B[n - 1];
    p(first);
    p(last);
    unsigned long long ans = 1;
    for (auto el : segLen) {
        ans = ans * moduleexp(factMod(el, m), m - 2, m);
        ans = ans % m;
        ans = ans * moduleexp(2, el - 1, m);
        ans = ans % m;
    }
    p(ans);
    unsigned int unvisitedNum = A - n;
    while(unvisitedNum > 0) {
        ans = ans * unvisitedNum;
        ans = ans % m;
        unvisitedNum--;
    }
    p(ans);
    p(moduleexp(first, m - 2, m));
    ans = ans * moduleexp(factMod(first, m), m - 2, m);
    ans = ans % m;
    ans = ans * moduleexp(factMod(last, m), m - 2, m);
    ans = ans % m;
    return (int)ans;
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
    int b;cin >> b;
	vector<int> A(b);
	for (int i = 0; i < b ; i++) {
		cin >> A[i];
	}
	p(solve(a,A));
	return 0;
} 

