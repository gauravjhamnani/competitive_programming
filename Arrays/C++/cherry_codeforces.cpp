#include <iostream>
#include <bits/stdc++.h>

// https://codeforces.com/problemset/problem/1554/A

#define p(n) cout << n << endl;

using namespace std;

void solve(vector<long long> &v, int n) {
    long long  answer = v[0] * v[1];
    for (int i = 1 ; i < n - 1 ; i++) {
        answer = max(answer, v[i] * v[i + 1]);
    }
    cout << answer << endl;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n;cin >> n;
        vector<long long> A(n);
        for (int i = 0 ; i < n ; i++) {
            cin >> A[i];
        }
        solve(A, n);
    }
    return 0;
} 
