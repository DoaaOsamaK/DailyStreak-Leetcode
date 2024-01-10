class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        int time = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode startnode = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.val==start)
                startnode = node;
                if(node.left!=null){
                  q.add(node.left);
                  map.put(node.left.val,node);
                }
                if(node.right!=null){
                  q.add(node.right);
                  map.put(node.right.val,node);
                }
            }
        }
        q.add(startnode);
        HashSet<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                set.add(node.val);
 if(map.containsKey(node.val)&&!set.contains(map.get(node.val).val)){
                   q.add(map.get(node.val));
                }
                if(node.left!=null&&!set.contains(node.left.val))
                q.add(node.left);
                 if(node.right!=null&&!set.contains(node.right.val))
                q.add(node.right);
            }
            
        }
        return time-1;
    }
}