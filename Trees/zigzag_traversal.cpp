#include "bits/stdc++.h"
#include <string>

#define p(n) cout << n << endl;
#define pv(a) for (int i = 0; i < a.size() ; i++) cout << a[i] << " "; cout << endl;
#define ps(a) for (auto i = a.begin(); i != a.end() ; i++) cout << *i << " "; cout << endl;
#define pm(a) for (auto itr = a.begin(); itr != a.end(); ++itr) cout << '\t' << itr->first << '\t' << itr->second << '\n'; cout << endl;
#define p2v(vect) cout << endl; for (int i = 0; i < vect.size(); i++) { for (int j = 0; j < vect[i].size(); j++) { cout << vect[i][j] << " "; }   cout << endl; }   cout << endl;

using namespace std;
// Problem Link : https://www.interviewbit.com/problems/wave-array/
int maximumGap(vector<int> &a) {
    int n = a.size(), maxi = 0, mini = INT_MAX;
    if (n <= 1) {
        return 0;
    }
    for (int i = 0 ; i < n ; i++) {
        maxi = max(maxi, a[i]);
        mini = min(mini, a[i]);
    }
    int gap = (maxi - mini)/(n - 1);
    int m = (maxi - mini)/gap + 1;
    vector<pair<int, int>> bucket(m, make_pair(INT_MAX, INT_MIN));
    for (int i = 0 ; i < n ; i++) {
        int index = (a[i] - mini)/gap;
        if (a[i] < bucket[index].first) {
            bucket[index].first = a[i];
        }
        if (a[i] > bucket[index].second) {
            bucket[index].second = a[i];
        }
        pm(bucket);
    }
    int prevMax = -1, ans = 0;;
    int i = 0 ;
    while (i < m) {
        if (bucket[i].first == INT_MAX) {
            i++;
            continue;
        }
        if (prevMax == -1) {
            prevMax = bucket[i].second;
            i++;
        } else {
            ans = max(ans, bucket[i].first - prevMax);
            i++;
            prevMax = bucket[i].second;
        }
    }
    return ans;
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
    vector<int> A(n);
    for (int i = 0 ; i < n ; i++) {
        cin >> A[i];
    }
	p(maximumGap(A));
	return 0;
} 



