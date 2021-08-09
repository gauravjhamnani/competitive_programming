#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/maximum-area-of-triangle/


int solve(vector<string> &A) {
    int n = A.size();
    int m = A[0].size();
    vector<vector<int>> firsts(m, vector<int>(6, -1));
    vector<char> vals{'r', 'g', 'b'};
    for ( int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            for (int pt = 0 ; pt < 3 ; pt++) {
                char ch = vals[pt];
                if (A[j][i] == ch) {
                    firsts[i][3 + pt] = j;
                    if (firsts[i][pt] == -1) {
                        firsts[i][pt] = j;
                    }
                    break;
                } 
            }
        }
    }
    p2v(firsts);

    vector<int> columnFirsts(6, -1);
    for (int i = 0 ; i < m ; i++) {
        for (int pt = 0 ; pt < 3 ; pt++) {
            if (firsts[i][pt] != -1) {
                if (columnFirsts[pt] == -1) {
                    columnFirsts[pt] = i;
                }
                columnFirsts[3 + pt] = i;
            }
        }
    }
    pv(columnFirsts);


    double maxArea = -1;
    for (int i = 0 ; i < m ; i++) {

        for (int pt = 0 ; pt < 3 ; pt++) {
            if (firsts[i][(pt + 1) % 3] != -1 && firsts[i][(pt + 2) % 3] != -1 && columnFirsts[pt] != -1) {
                double maxHeight = -1, maxBase = -1;
                maxBase = 1 + max(abs(firsts[i][(pt + 1) % 3] - firsts[i][((pt + 2) % 3) + 3]), abs(firsts[i][(pt + 2) % 3] - firsts[i][((pt + 1) % 3) + 3]));
                maxHeight = max(abs(i - columnFirsts[pt]), abs(i - columnFirsts[pt + 3]));
                maxHeight = (maxHeight != 0) ? (maxHeight + 1) : 0;
                maxArea = max(maxArea, (maxBase * maxHeight)/(2.0));
            }
        }

    }

    return ceil(maxArea);

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
	vector<string> A(n);
	for (int i = 0; i < n ; i++) {
		cin >> A[i];
	}
	p(solve(A));
	return 0;
} 

