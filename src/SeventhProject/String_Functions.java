package SeventhProject;

public class String_Functions {
    public static void main(String[] args) {
        String str="Hello World";
        String str1="Hello World";

        System.out.println(str.equals(str1));   //returns true if str and str1 same including the case
        System.out.println(str.equalsIgnoreCase(str1));     //returns true if str and str1 same without considering the case
        System.out.println(!str.equals(str1));      //not equals to
        System.out.println(str.toLowerCase());      //changes string to lower case
        System.out.println(str.toUpperCase());      //changes string to upper case
        System.out.println(str.length());           //Returns length of string
        System.out.println(str.indexOf('l'));       //Returns index number of given character
        System.out.println(str.charAt(4));          //Returns value of character from string of given index
        System.out.println(str.concat(str1));       //Joins two strings
        System.out.println(str.replace('e','a'));  //Replaces the given character with new character
        System.out.println(str.substring(3));       //Prints string after the given index
        System.out.println(str.contains("e"));
    }
}
