class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    li.get(i).add(j);
                   
                }
            }
        }

        boolean[] visited=new boolean[n];
        int province=0;

        for(int i=0;i<n;i++){
            if(!visited[i])
            {
                province++;
                dfs(i,li,visited);   
            }
           
        }

        return province;




    }
    private void dfs(int node,ArrayList<ArrayList<Integer>> li,boolean[] visited){
        visited[node]=true;
        for(int ele:li.get(node)){
            if(!visited[ele])
            dfs(ele,li,visited);
        }
    }
}