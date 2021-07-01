#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/maximum-area-of-triangle/


void compare(int *l, int *r, int *maxDiff, int currDiff, int i, int j) {
    if (currDiff > *maxDiff) {
        *maxDiff = currDiff;
        *l = i;
        *r = j;
    }
}

vector<int> flip(string a) {
    int n = a.size();
    int maxDiff = 0;
    int l = -1, r = -1;
    int i = 0, j = 0;
    int currDiff = 0;
    while (i < n && j < n) {
        if (a[j] == '1') {
            if (currDiff > 0) {
                currDiff--;
                j++;
                compare(&l, &r, &maxDiff, currDiff, i, j);
            } else {
                j++;
                i = j;
                currDiff = 0;
            }
        } else  {
            currDiff++;
            j++;
            compare(&l, &r, &maxDiff, currDiff, i, j);
        }
    }
    if (maxDiff != 0) {
        return vector<int>{l + 1 ,r};
    } else {
        return vector<int>(0);
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
	string a;cin >> a;
	// vector<string> A(n);
	// for (int i = 0; i < n ; i++) {
	// 	cin >> A[i];
	// }
	pv(flip(a));
	return 0;
} 

