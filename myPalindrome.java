import java.util.Scanner;

class myPalindrome{
    static int top=-1;
    //declare a char type array
    static char StackArray[]; 

    //push method to add new element to top
    static void push(char x){
        if (top == StackArray.length - 1) {
            System.out.println("Stack is full");
        } else {
            top=top+1;
            StackArray[top]=x;
        }
    }
    
    //pop method to remove and return the top element
    static char pop(){
        if (top == -1) {
            return '\0';
        } else {
            char temp;
            temp = StackArray[top];
            top=top-1;
            return temp;
        }
    }

 
    //Function return true if input is a Palindrome
    static boolean isPalindrome(char inputArray[]){
        //get the no of characters in userinput
        int length = inputArray.length;
        //mid is used to split the userinput in to two
        int mid = length / 2;
        StackArray = new char[mid*4];//each character in Java is two bytes 

        //first half of the userinput is stored in the stack
        for (int i = 0; i < mid; i++){
            push(inputArray[i]);
        }
        //Now i=mid+1
        //if the length is odd must skip the median
        if (length%2!=0) {
            mid=mid+1;
        }
    
        for (int i = mid; i < length; i++) {
            char top = pop();
            if (top != inputArray[i]) {
                return false;
            }
        }
        return true;
        
    }
 
  //Main method
    public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);

    System.out.println("Enter you input");

    //Get user input
    String userInput = input.nextLine();
    //Split user input to a Char array
    char[] inputArray = userInput.toCharArray();
    //use the checking method
    System.out.println(isPalindrome(inputArray)+" A Palindrome"); 

    }
}