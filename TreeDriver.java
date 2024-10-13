import java.util.*;

public class TreeDriver{
    public static void main(String[] args){
        
        TreeNode<String> CDrive = new TreeNode<String>("CDrive");

        TreeNode<String> ProgramFiles = new TreeNode<String>("ProgramFiles", CDrive);
        TreeNode<String> Users = new TreeNode<String>("Users", CDrive);
       

        TreeNode<String> Java = new TreeNode<String>("Java", ProgramFiles);
        TreeNode<String> BlueJ = new TreeNode<String>("BlueJ", ProgramFiles);

        TreeNode<String> Monroe = new TreeNode<String>("Monroe", Users);
        TreeNode<String> Guidry = new TreeNode<String>("Guidry", Users);


        System.out.println(CDrive);
        System.out.println("Pre Sort: "+ TreeNode.preSort(CDrive, new LinkedHashSet<TreeNode<String>>()));
        System.out.println("In Sort: "+TreeNode.inSort(CDrive, new LinkedHashSet<TreeNode<String>>()));
        System.out.println("Post Sort: "+TreeNode.postSort(CDrive, new LinkedHashSet<TreeNode<String>>()));
    }
}