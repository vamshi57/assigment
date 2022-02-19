package com.vamshi.proj.arraytree;

class Tree { 
 public static void main(String[] args) 
 { 
     Arrayimp obj = new Arrayimp(); 
     obj.rootCreate("A"); 
     obj.setLeft("B", 0); 
     obj.setRight("C", 0); 
     obj.setLeft("D", 1); 
     obj.setRight("E", 1); 
     obj.setLeft("F", 2); 
     obj.printTree(); 
 } 
} 

class Arrayimp { 
 static int root = 0; 
 static String[] str = new String[10]; 
   
 public void rootCreate(String key) 
 { 
     str[0] = key; 
 } 


 public void setLeft(String key, int root) 
 { 
     int t = (root * 2) + 1; 

     if(str[root] == null){ 
         System.out.printf("Can't set child at %d, no parent found",t); 
     }else{ 
         str[t] = key; 
     } 
 } 
 public void setRight(String key, int root) 
 { 
     int t = (root * 2) + 2; 

     if(str[root] == null){ 
         System.out.printf("Can't set child at %d, no parent found",t); 
     }else{ 
         str[t] = key; 
     } 
 } 

 public void printTree() 
 { 
     for (int i = 0; i < 10; i++) { 
         if (str[i] != null) 
             System.out.print(str[i]+"  "); 
        
            
           
     } 
 } 
} 