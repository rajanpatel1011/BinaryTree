package com.rajan.treedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class treeControllerTest {

    @Test
    public void treeCreationInOrderTest(){
        TreeContoller treeContoller = new TreeContoller();
         Assertions.assertEquals("Order[4, 2, 5, 1, 6, 3, 7]",treeContoller.treeCreate("InOrder"));
    }
    @Test
    public void treeCreationPostOrderTest(){
        TreeContoller treeContoller = new TreeContoller();
        Assertions.assertEquals("Order[4, 5, 2, 6, 7, 3, 1]",treeContoller.treeCreate("PostOrder"));
    }
    @Test
    public void treeCreationPreOrderTest(){
        TreeContoller treeContoller = new TreeContoller();
        Assertions.assertEquals("Order[1, 2, 4, 5, 3, 6, 7]",treeContoller.treeCreate("PreOrder"));
    }
}
