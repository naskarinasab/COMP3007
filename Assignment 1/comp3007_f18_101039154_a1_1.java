//Name: Navid Askari Nasab
//Student #: 101039154

import java.util.*;

public class comp3007_f18_101039154_a1_1{
  /*PART A*/
  public static char upperCase(char letter)
  {
    int asciiNumber = (int)letter;
    if(asciiNumber>64 && asciiNumber<91){ //Just checking to see if it's already uppercase
      return letter;
    }
    asciiNumber = asciiNumber - 32; //difference between lowercase and upper case of a letter is 32 on Ascii table
    return (char)asciiNumber;
  }

  public static char lowerCase(char letter)
  {
    int asciiNumber = (int)letter;
    if(asciiNumber>96 && asciiNumber<122){ //Just checking to see if it's already lowercase
      return letter;
    }
    asciiNumber = asciiNumber + 32; //difference between lowercase and upper case of a letter is 32 on Ascii table
    return (char)asciiNumber;
  }

  /*PART B*/
  public static String changeCase(String word){
    if(word.length() == 1){
      return upperCase(word.charAt(0)) + "";
    }
    else{
      int n = word.length()-1;
      return changeCase(word.substring(0, n)) + lowerCase(word.charAt(n));
    }
  }

  /*PART C*/
  public static String camelCase(List<String> wordList){
    if(wordList.size() == 0){ //Base Case
      return "";
    }
    else{
      if(wordList.size() == 1){ //The first word has been reached so, the first letter needs to be lower case.
        String returnWord = changeCase(wordList.get(0));
        return lowerCase(returnWord.charAt(0)) + returnWord.substring(1, returnWord.length());
      }
      int n = wordList.size()-1;
      return camelCase(wordList.subList(0, n)) + changeCase(wordList.get(n));
    }
  }

  /*PART D*/
  public static String getCapitals(String camel){
    if(camel.length() == 1){
      return "";
    }
    else{
      int n = camel.length()-1;
      int asciiNumber = (int)camel.charAt(n);
      if(asciiNumber>96 && asciiNumber<122){ //Checking if the character is lowercase
        return getCapitals(camel.substring(0,n));
      }
      return getCapitals(camel.substring(0, n)) + camel.charAt(n);
    }
  }

  /*PART E*/
  public static void main(String[] args) {
    boolean repeat = true;
    while(repeat ==true){
      List<String> userList = new ArrayList<>();
      /*USER INPUT*/
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter a phrase you would like in Camel Acrostics:");
      String userPhrase = keyboard.nextLine();

      /*PARSING USER INPUT*/
      String[] words = userPhrase.split(" ");
      userList.addAll(Arrays.asList(words));

      /*CALLING RECURSION FUNCTIONS*/
      String camel = camelCase(userList);
      String capitals = getCapitals(camel);

      /*OUTPUT*/
      System.out.printf("Phrase in camel case: %s\n", camel);
      System.out.printf("Phrase in Camel Acrostics: %s\n", capitals);

      /*Checking for repeat*/
      System.out.println("Would you like to repeat? (Y/N): ");
      String userRepeat = keyboard.next();
      if (userRepeat.equals("Y") || userRepeat.equals("y") || userRepeat.equals("yes") || userRepeat.equals("Yes")){
        repeat = true;
      }
      else{
        repeat = false;
      }
    }
    System.out.println("Goodbye!");
  }

}
