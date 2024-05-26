class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(),points.end(),[](vector<int>& a,vector<int>&b){
           return a[1]!=b[1]? a[1]<b[1]:a[0]<b[0];
        });
        long long arrows=0,prev_loc=-1*1e10;
        for(auto & point:points) {
            int s=point[0],e=point[1];
            if(s<=prev_loc) continue;
            arrows++;
            prev_loc=e;
        }
        return arrows;
    }
};