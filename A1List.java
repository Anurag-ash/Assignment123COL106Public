// Implements Dictionary using Doubly Linked List (DLL)
// Implement the following functions using the specifications provided in the class List
//We will use sentinel nodes
public class A1List extends List {

    private A1List  next; // Next Node
    private A1List prev;  // Previous Node 

    public A1List(int address, int size, int key) { 
        super(address, size, key);//super will call A1List's upper class's(List(Dictionary)) constructer.
        this.next=null;
        this.prev=null; 	
    }
    
    public A1List(){
        super(-1,-1,-1);//Every thing(key,address,size) is -1.
        // This acts as a head Sentinel
	
        A1List tailSentinel = new A1List(-1,-1,-1); // Intiate the tail sentinel
        
        this.next = tailSentinel;
        tailSentinel.prev = this;
    }

    public A1List Insert(int address, int size, int key)
    {
        A1List new_node=new A1List(address,size,key);
        new_node.prev=this;
        new_node.next=this.next;
        this.next.prev=new_node;
        this.next=new_node;
            	
        return new_node;
    }

    public boolean Delete(Dictionary d) 
    {
        if(this.key==d.key && this.address==d.address && this.size ==d.size){
            this.prev.next=this.next;
            this.next.prev=this.prev;
            return true;
        }
        A1List forward=this.next;
        A1List backward=this.prev;
        while(forward.key!=-1&& backward.key!=-1){
            if(forward.key==d.key ){
                if(forward.address==d.address && forward.size ==d.size){
                    forward.next.prev=forward.prev;
                    forward.prev.next=forward.next;
                    return true;
                }
            }
            if(backward.key==d.key){
                if(backward.address==d.address && backward.size ==d.size){
                    backward.next.prev=backward.prev;
                    backward.prev.next=backward.next;
                    return true;
                }
            }
            forward=forward.next;
            backward=backward.prev;
        }
        while(forward.key!=-1){
            if(forward.key==d.key ){
                if(forward.address==d.address && forward.size ==d.size){
                    forward.next.prev=forward.prev;
                    forward.prev.next=forward.next;
                    return true;
                }
            }
            forward=forward.next;
        }
        while(backward.key!=-1){
            if(backward.key==d.key){
                if(backward.address==d.address && backward.size ==d.size){
                    backward.next.prev=backward.prev;
                    backward.prev.next=backward.next;
                    return true;
                }
            }
            backward=backward.prev;
        }
        return false;
    }

    public A1List Find(int k, boolean exact)
    { 
        if(exact){
            A1List backward=this.prev;
            A1List forward=this;
            while(forward.key!=-1 && backward.key!=-1){
                if(forward.key==k){
                    return forward;
                }
                if(backward.key==k){
                    return backward;
                }
                backward=backward.prev;
                forward=forward.next;
            }
            while(forward.key!=-1){
                if(forward.key==k){
                    return forward;
                }
                forward=forward.next;
            }
            while(backward.key!=-1){
                if(backward.key==k){
                    return backward;
                }
                backward=backward.prev;
            }
        }
        else{
            A1List backward=this.prev;
            A1List forward=this;
            while(forward.key!=-1 && backward.key!=-1){
                if(forward.key>=k){
                    return forward;
                }
                if(backward.key>=k){
                    return backward;
                }
                backward=backward.prev;
                forward=forward.next;
            }
            while(forward.key!=-1){
                if(forward.key>=k){
                    return forward;
                }
                forward=forward.next;
            }
            while(backward.key!=-1){
                if(backward.key>=k){
                    return backward;
                }
                backward=backward.prev;
            }
        return null;
    }

    public A1List getFirst()
    {
        A1List backward=this;
        while(backward.key!=-1){
            backward=backward.prev;
        }
        if(backward.next.key!=-1){
            return backward.next;
        }
        return null;
    }
    
    public A1List getNext() 
    {
        if(this.next==tailSentinel){
            return null;
        }
        return this.next;
    }

    public boolean sanity()
    {
        return true;
    }

}


