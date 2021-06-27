#include "bits/stdc++.h"

#define p(n) cout << n << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/old/problems/minimum-lights-to-activate/

int solve(vector<int> &A, int B) {
    int n = A.size();
    vector<int> farthestRightLight(n, -1);
    vector<int> nearestLeftLight(n, -1);
    for (int i = min(B, n) - 1 ; i >= 0; i--) {
        if (A[i] == 1) {
            farthestRightLight[0] = i;
            break;
        }
    }

    for (int i = 1; i < n; i++) {
        if ((i + B - 1) < n && A[i + B -1] == 1) {
            farthestRightLight[i] = i + B - 1;
        } else {
            if (farthestRightLight[i-1] == (i-1)) {
                farthestRightLight[i] = -1;
            } else {
                farthestRightLight[i] = farthestRightLight[i-1];
            }
        }
    }

    for (int i = 0; i < n; i++) {
        cout << farthestRightLight[i] << " ";
    }
    cout << endl;

    nearestLeftLight[0] = A[0] - 1; 
    for (int i = 1; i < n; i++) {
        if (A[i] == 1) {
            nearestLeftLight[i] = i;
            continue;
        }
        if (nearestLeftLight[i-1] != (i - B)) {
            nearestLeftLight[i] = nearestLeftLight[i - 1];
        } else {
            nearestLeftLight[i] = -1;
        }
    }

    for (int i = 0; i < n; i++) {
        cout << nearestLeftLight[i] << " ";
    }
    cout << endl;

    int pos = 0;
    int answer = 0;
    while(pos < n) {
        if (farthestRightLight[pos] != -1) {
            answer++;
            pos = farthestRightLight[pos] + B;
        } else if (nearestLeftLight[pos] != -1) {
            answer++;
            pos = nearestLeftLight[pos] + B;
        } else {
            return -1;
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
	int b;cin >> b;
	p(solve(A, b));
	return 0;
} 

