package blind75.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InvertTree {

    public static List<BinaryTreeNode> buildTree() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = ((int) Math.pow(2, Integer.parseInt(br.readLine()))) - 1;
        List<BinaryTreeNode> nodeList = new ArrayList<BinaryTreeNode>(size);

        IntStream.range(0, size).forEach(a -> nodeList.add(new BinaryTreeNode(-1, null, null)));
        IntStream.range(0, size).forEach(a -> {
            try {
                String temp = br.readLine();
                int i = Integer.parseInt(temp.split(" ")[0]);
                nodeList.get(i).val = Integer.parseInt(temp.split(" ")[1]);

                if (2 * i + 1 < size) {
                    nodeList.get(i).left = nodeList.get(2 * i + 1);
                }

                if (2 * i + 2 < size) {
                    nodeList.get(i).right = nodeList.get(2 * i + 2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        br.close();
        return nodeList;
    }

    public static void main(String[] args) throws IOException {
        List<BinaryTreeNode> list = buildTree();
        BinaryTreeNode root = list.get(0);
        root.inorderTraversal();
        root = invertTree(root);
        System.out.println();
        root.inorderTraversal();
    }

    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root != null) {
            BinaryTreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }
        return root;
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void inorderTraversal() {
        if (left != null)
            left.inorderTraversal();
        if (val != -1)
            System.out.print(val + " ");
        if (right != null)
            right.inorderTraversal();
    }
}
