#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define ps(a) for (auto i = a.begin(); i != a.end() ; i++) cout << *i << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/city-tour/

int solve(vector<vector<int> > &A, int B) {
    int n = A.size();
    vector<vector<int>> sumTillHere(n, vector<int>(n, 0));
    for (int i = 0 ; i < n ; i++) {
        for (int j = 0 ; j < n ; j++) {
            int topSum = 0;
            int leftSum = 0;
            int diagSum = 0;
            if (i > 0) {
                topSum = sumTillHere[i-1][j];
            }
            if (j > 0) {
                leftSum = sumTillHere[i][j-1];
            }
            if (i > 0 && j > 0) {
                diagSum = sumTillHere[i-1][j-1];
            }
            sumTillHere[i][j] = A[i][j] + leftSum + topSum - diagSum; 
        }
    }
    int maxi = INT_MIN + 1;
    for (int i = B - 1 ; i < n ; i++) {
        for (int j = B - 1 ; j < n ; j++) {
            int x = i + 1 - B, y = j + 1 - B;
            int topSum = 0;
            int leftSum = 0;
            int diagSum = 0;
            if (x > 0) {
                topSum = sumTillHere[x-1][j];
            }
            if (y > 0) {
                leftSum = sumTillHere[i][y-1];
            }
            if (x > 0 && y > 0) {
                diagSum = sumTillHere[x-1][y-1];
            }
            int currSum = sumTillHere[i][j] - topSum - leftSum + diagSum;
            maxi = max(maxi, currSum);
        }
    }
    return maxi;
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
    vector<vector<int>> A(n, vector<int>(n, 0));
    for (int i = 0 ; i < n ; i++) {
        for (int j = 0 ; j < n ; j++) {
            cin >> A[i][j];
        }
    }
    int b;cin >> b;
	p(solve(A,b));
	return 0;
} 

