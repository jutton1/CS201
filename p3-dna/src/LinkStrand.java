public class LinkStrand implements IDnaStrand {	
    
    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;
    private Node reverseHelperNode;

    

    public LinkStrand(){
		this("");
	}

    /**
	 * Create a strand representing s. No error checking is done to see if s
	 * represents valid genomic/DNA data.
	 * 
	 * @param s
	 *            is the source of cgat data for this strand
	 */
    public LinkStrand(String s) {
        initialize(s);
    }

    
    private class Node {
        String info;
        Node next;
        Node(String x){
            info = x;
        }
        Node(String x, Node nextNode) {
            info = x;
            next = nextNode;
        }
        public String getInfo() {
            return info;
        }
        
        public Node getNext() {
            return next;
        }
        public void setInfo(String info) {
            this.info = info;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        Node firstNode = new Node(source);
        myFirst = firstNode;
        myAppends = 0;
        mySize = source.length();
        myCurrent = myFirst;
        myLast = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        Node toAppend = new Node(dna);
        myLast.next = toAppend;
        mySize += dna.length();
        myLast = myLast.next;
        myAppends++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        Node reverseHelperNode = new Node(myFirst.info);
        Node current = myFirst;
        Node previous = reverseHelperNode;
        StringBuilder temporary = new StringBuilder();
        int check = 0;
        // Complicated
        while (current != null) {
            // reverse our current string
            temporary.append(current.info);
            temporary.reverse();
            
            // Our new linked list has the first thing but backwards of the previous
            if (check == 0) {
                reverseHelperNode.setInfo(temporary.toString());
                check ++;
            }
            else {
                reverseHelperNode = new Node(temporary.toString(), previous);
            }
            previous = reverseHelperNode;

            current = current.next;
            temporary.setLength(0);

        }

        // copy over the new Nodes to the reversed Strand.
        current = reverseHelperNode;
        LinkStrand reversedStrand = new LinkStrand(current.info);
        current = current.next;
        while (current != null) {
            reversedStrand.append(current.info);
            current = current.next;
        }
        
        return reversedStrand;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        // got help from TA
        if((index < 0) || (index>=mySize)) {
            throw new IndexOutOfBoundsException("invalid index");
        }

        if (index < myIndex) {
            myCurrent = myFirst;
            myIndex = 0;
            myLocalIndex = 0;
        }

        while (myIndex < index) {
            myLocalIndex++;
            myIndex++;
            if (myLocalIndex == myCurrent.info.length()) {
                myCurrent = myCurrent.next;
                myLocalIndex = 0;
            }
        }

        return myCurrent.info.toCharArray()[myLocalIndex];

        /*
        int start = 0;
        int i = 0;

        // Start looping at our previous myCurrent
        if (index >= myIndex) {
            start = myIndex;
        }
        // If the index is before what we are currently at, start from the beginning
        else {
            start = 0;
            myLocalIndex = 0;
            myCurrent = myFirst;
        }

        for (i = start; i < index; i+= myCurrent.info.length()) {
            if ((index - i) < myCurrent.info.length()){
                break;
            }
            if (myCurrent.next == null) {
                throw new IndexOutOfBoundsException();
            }
            myCurrent = myCurrent.next;
        }
        for (int j = 0; j < myCurrent.info.length(); j++) {
            if (i == index) {
                return myCurrent.info.toCharArray()[j];
            }
            i++;
            myLocalIndex++;
        }
        

        return 0; */
    }

    @Override
    public String toString() {
        StringBuilder fullString = new StringBuilder();
        Node stringHelper = myFirst;
        while (stringHelper != null) {
            fullString.append(stringHelper.info);
            stringHelper = stringHelper.next;
        }
        return fullString.toString();
    }

}


