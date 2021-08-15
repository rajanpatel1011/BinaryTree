package com.rajan.treedemo;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TreeContoller {

    @GetMapping("/tree/{travers}")
    @ResponseBody
    public String treeCreate(@PathVariable("travers") String t){
        List<Integer> data = new ArrayList<>();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root=new Node(1);
        binaryTree.root.left=new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        switch (t) {
            case "InOrder":
                data.addAll(binaryTree.treeInOrder());
                break;
            case "PostOrder":
                data.addAll(binaryTree.treePostOrder());
                break;
            case "PreOrder":
                data.addAll(binaryTree.treePreOrder());
                break;
        }
        return "Order"+data;
    }

}

 class Node{
    int key;
    Node left;
    Node right;

    Node(int data){
        key=data;
        left = right=null;
    }
}

class BinaryTree{
    Node root;
    BinaryTree(){root=null;}
    List<Integer> datas=new ArrayList<>();

    List<Integer> treeInOrder(Node node,List<Integer> datas){

        if(node==null){
            return datas;
        }
        treeInOrder(node.left,datas);
        datas.add(node.key);
        treeInOrder(node.right,datas);
        return datas;
    }

    List<Integer> treePostOrder(Node node,List<Integer> datas){
        if(node ==null){
            return datas;
        }
        treePostOrder(node.left,datas);
        treePostOrder(node.right,datas);
        datas.add(node.key);
        return datas;
    }

    List<Integer> treePreOrder(Node node,List<Integer> datas){
        if(node==null){
            return datas;
        }

        datas.add(node.key);
        treePreOrder(node.left,datas);
        treePreOrder(node.right,datas);
        return datas;
    }
            List<Integer> treeInOrder(){return treeInOrder(root,datas);}
            List<Integer> treePreOrder(){return treePreOrder(root,datas);}
            List<Integer> treePostOrder(){return treePostOrder(root,datas);}
}