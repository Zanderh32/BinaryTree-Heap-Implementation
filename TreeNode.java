import java.util.*;
public class TreeNode<E>{
    private E data;
    private TreeNode<E> parent;
    private List<TreeNode<E>> children;
    

    public TreeNode(E data) {

        this.data = data;

        this.parent = null;

        this.children = new LinkedList<TreeNode<E>>();

    }

    public TreeNode(E data, TreeNode<E> parent) {

        this.data = data;

        this.parent = parent;

        this.children = new LinkedList<TreeNode<E>>();

        parent.addChild(this);

    }

    public E getData() { 
        return data;
    } 

    public void setData(E d) { 
        data = d;
    } // this method should change this node's data
    public TreeNode<E> getParent() { 
        return parent;
    } // should return this node's parent
    public void setParent(TreeNode<E> n) { 
        parent = n;
    } // should change this node's parent
    public List<TreeNode<E>> getChildren() {
        return children;
    } // should return this node's children
    public void addChild(TreeNode<E> n) {
        children.add(n);
    } // should add "n" to children list and set its parent to this
    public void removeChild(TreeNode<E> n) {
        if(children.contains(n)){
            children.remove(children.indexOf(n));
        }
    } // should remove "n" from children list and set its parent to null
    public boolean isRoot() { 
        return parent == null;
    } // should return true only if parent is null
    public boolean isLeaf() {
        return children.size() == 0;
    } // should return true only if this node has no children
    public String toString() { 
        return data + "";
    } // should instead return this node's data as a String
    public static <E> Set<TreeNode<E>> BFS(TreeNode<E> start) { 
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        LinkedHashSet<TreeNode<E>> set = new LinkedHashSet<TreeNode<E>>();
        q.add(start);
        while(q.size() != 0){
            TreeNode<E> c = q.remove();
            set.add(c);
            for(TreeNode<E> n : start.getChildren()){
                if(!set.contains(n)){
                    q.add(n);
                }
            }
        }
        return set;
    }

    public static <E> LinkedHashSet<TreeNode<E>> preSort(TreeNode<E> start, LinkedHashSet<TreeNode<E>> visited){
        
        visited.add(start);
        if(start.getChildren().size() >= 1){
            preSort(start.getChildren().get(0) , visited);
        }
        if(start.getChildren().size() == 2){
            preSort(start.getChildren().get(1) , visited);
        }
        return visited;
        
    }
    public static <E> LinkedHashSet<TreeNode<E>> inSort(TreeNode<E> start, LinkedHashSet<TreeNode<E>> visited){
        
        
        if(start.getChildren().size() >= 1){
            inSort(start.getChildren().get(0) , visited);
        }
        visited.add(start);
        if(start.getChildren().size() == 2){
            inSort(start.getChildren().get(1) , visited);
        }
        return visited;
        
    }
    public static <E> LinkedHashSet<TreeNode<E>> postSort(TreeNode<E> start, LinkedHashSet<TreeNode<E>> visited){
        
        
        if(start.getChildren().size() >= 1){
            postSort(start.getChildren().get(0) , visited);
        }
        if(start.getChildren().size() == 2){
            postSort(start.getChildren().get(1) , visited);
        }
        visited.add(start);
        return visited;
        
    }

}