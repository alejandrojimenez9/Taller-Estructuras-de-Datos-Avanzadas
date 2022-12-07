class Solution{
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> list = new ArrayList();
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0){
            list.add(0);
            return list;
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int i=0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        while(n > 2){
            int size = q.size();
            n -= size;
            for(int i=0; i < size; i++){
                int temp = q.poll();
                for(int dad : graph[temp]){
                    if(indegree[dad] == 1) continue;
                    indegree[dad]--;
                    if(indegree[dad] == 1){
                        q.add(dad);
                        }
                }
            }
        }
    
        while (!q.isEmpty()){
            list.add(q.poll());
            
        }
        return list;
    }
}