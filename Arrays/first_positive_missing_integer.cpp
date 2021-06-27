#include "bits/stdc++.h"

#define p(n) cout << n << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/old/problems/minimum-lights-to-activate/

int firstMissingPositive(vector<int> &A) {
    
    int n = A.size();
    for (int i = 0 ; i < n ; i++) {
        if (A[i] <= 0 || A[i] > n || A[i] == (i + 1)) {
            continue;
        }
        int found = A[i];
        while (found >=1 && found <= n && A[found - 1] != found) {
            int temp = A[found - 1];
            A[found - 1] = found;
            found = temp;
        }
    }
    int answer = n + 1;
    for (int i = 0 ; i < n ; i++) {
        if (A[i] != (i+1)) {
            answer = i + 1;
        }
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
	p(firstMissingPositive(A));
	return 0;
} 

