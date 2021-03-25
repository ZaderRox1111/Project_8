package p8_package;

public class EncryptionClass_I
   {

      //The overall goal of this program is to encrypt and decrypt messages using a key
      
      //Part 1:
      //Print a title and instructions
      //Ask user for both the key and the message
      //convert the string into a new encrypted message using the key
      //display the encrypted message
      //Part 2:
      //display the instructions again, and get the key and message from user
      //convert the message back to normal using the key
      //display the final message
      
      //Initialize constants and conIO class
      public static final int TWO_ENDLINES = 2;
      
      public static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args)
         {
            // TODO Auto-generated method stub
            
            //Create variables needed
            String keyString, messageString;
            int[] keyArray;
            char[] messageArray, encryptedArray, decryptedArray;
            
            //display title and instructions for part 1
             //Method: printString, printEndlines
            conIO.printString("Encryption / Decryption Program");
            conIO.printEndlines(TWO_ENDLINES);
            conIO.printString("Part one accepts a series of key integers and then a string to be encrypted.");
            conIO.printEndlines(TWO_ENDLINES);
            
            //Ask user for the number key and store as a key variable
             //Method: promptForString
            keyString = conIO.promptForString("Enter series of numbers: ");
            
            //Ask user for the message to encrypt and store as a message variable
             //Method: promptForString, printEndline
            messageString = conIO.promptForString("Enter string to be encrypted: ");
            conIO.printEndline();
            
            //Turn the key into an integer array
             //Method: convertStringToIntArray
            keyArray = convertStringToIntArray(keyString);
            
            //Turn the message into a character array
             //Method: convertStringToCharArray
            messageArray = convertStringToCharArray(messageString);
            
            //Using both arrays, add the key and message arrays together to get a final array
             //Method: encryptString
            encryptedArray = encryptString(keyArray, messageArray);
            
            //Display the final encrypted message
             //Method: displayStringWithLeader
            displayStringWithLeader("Encrypted String: ", encryptedArray);
            
            //Instructions for part 2 are displayed
             //Method: printString, printEndlines
            conIO.printString("Part two accepts a series of key integers and then a string to be decrypted.");
            conIO.printEndlines(TWO_ENDLINES);
            
            //A key and an encrypted message are asked for
             //Method: promptForString, printEndline
            keyString = conIO.promptForString("Enter series of numbers: ");
            messageString = conIO.promptForString("Enter string to be decrypted: ");
            conIO.printEndline();
            
            //Turn the key into an integer array
             //Method: convertStringToIntArray
            keyArray = convertStringToIntArray(keyString);
           
            //Turn the message into a character array
             //Method: convertStringToCharArray
            messageArray = convertStringToCharArray(messageString);
           
           //Using both arrays, subtract the key from the message array to get a final array
            //Method: decryptString
           decryptedArray = decryptString(keyArray, messageArray);

          //Display the final decrypted message
            //Method: displayStringWithLeader
           displayStringWithLeader("Decrypted String: ", decryptedArray);
            
          //End Program
            //Method: printString
           conIO.printString("End Program");
            
         }
      
      /*
       Name: convertStringToIntArray
       Process: converts string to int array
       Method Input/Parameters: keyString (String)
       Method Output/Parameters: none
       Method Output/Returned: integer array (int[])
       Device Input/Keyboard: none
       Device Output/Monitor: none
       Dependencies: Console IO Class Tools
      */
      public static int[] convertStringToIntArray(String keyString) 
         {
            //create variables
            int index, stringLength, currentInt;
            char currentChar;
            int[] finalArray;
            
            //create the array with length of the string
            stringLength = keyString.length();
            finalArray = new int[stringLength];
            
            //Go through the string, and convert each number one by one into integers,
            //then store the integer into the array
            for (index = 0; index < stringLength; index++) 
               {
                  currentChar = keyString.charAt(index);
                  currentInt = charToInt(currentChar);
                  
                  finalArray[index] = currentInt;
               }
            
            //return the final array
            return finalArray;
         }
      
      /*
      Name: convertStringToCharArray
      Process: converts a string to a character array
      Method Input/Parameters: messageString (String)
      Method Output/Parameters: none
      Method Output/Returned: character string (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: Console IO Class Tools
     */
      public static char[] convertStringToCharArray(String messageString) 
         {
            //create variables
            int index, stringLength;
            char currentChar;
            char[] finalArray;
            
            //create the array with length of the string
            stringLength = messageString.length();
            finalArray = new char[stringLength];
            
            //Go through the string, and store each character into the new array
            for (index = 0; index < stringLength; index++) 
               {
                  currentChar = messageString.charAt(index);
                  
                  finalArray[index] = currentChar;
               }
            
            //return the final array
            return finalArray;
         }
      
      /*
      Name: encryptString
      Process: encrypts string by adding key values to the message
      Method Input/Parameters: keyArray (int[]), messageArray (char[])
      Method Output/Parameters: none
      Method Output/Returned: encryptedMessageArray (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: Console IO Class Tools
     */
      public static char[] encryptString(int[] keyArray, char[] messageArray) 
         {
            //create variables
            int keyIndex, messageIndex, messageLength, keyLength, keyInt;
            char currentChar, messageChar;
            char[] finalArray;
            
            messageLength = messageArray.length;
            keyLength = keyArray.length;
            finalArray = new char[messageLength];
            
            //loop through the message array, and add the integer at the index in keyArray
            //Use a modulo to loop through the key index at the same time
            //Store the result into the array
            for (messageIndex = 0; messageIndex < messageLength; messageIndex++) 
               {
                  keyIndex = messageIndex % keyLength;
                  messageChar = messageArray[messageIndex];
                  keyInt = keyArray[keyIndex];
                  
                  currentChar = (char) (messageChar + keyInt);
                  
                  finalArray[messageIndex] = currentChar;
               }
            
            //return the final array            
            return finalArray;
         }
      
      /*
      Name: decryptString
      Process: decrypts string by subtracting key values from the message
      Method Input/Parameters: keyArray (int[]), messageArray (char[])
      Method Output/Parameters: none
      Method Output/Returned: decryptedMessageArray (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: Console IO Class Tools
     */
      public static char[] decryptString(int[] keyArray, char[] messageArray) 
         {
            //create variables
            int keyIndex, messageIndex, messageLength, keyLength, keyInt;
            char currentChar, messageChar;
            char[] finalArray;
            
            messageLength = messageArray.length;
            keyLength = keyArray.length;
            finalArray = new char[messageLength];
            
            //loop through the message array, and subtract the integer at the index in keyArray
            //Use a modulo to loop through the key index at the same time
            //Store the result into the array
            for (messageIndex = 0; messageIndex < messageLength; messageIndex++) 
               {
                  keyIndex = messageIndex % keyLength;
                  messageChar = messageArray[messageIndex];
                  keyInt = keyArray[keyIndex];
                  
                  currentChar = (char) (messageChar - keyInt);
                  
                  finalArray[messageIndex] = currentChar;
               }
            
            //return the final array            
            return finalArray;
         }
      
      /*
      Name: displayStringWithLeader
      Process: displays leader with a string created from character array
      Method Input/Parameters: leader (String), charArray (char[])
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: Console IO Class Tools
     */
      public static void displayStringWithLeader(String leader, char[] charArray) 
         {
            //create variables
            int index, charArrayLength;
            char currentChar;
            
            charArrayLength = charArray.length;
            
            //print out the leader
             //Method: printString
            conIO.printString(leader);
            
            //loop through the array and print out each character as it goes
             //Method: for loop, printChar
            for (index = 0; index < charArrayLength; index++) 
               {
                  currentChar = charArray[index];
                  
                  conIO.printChar(currentChar);
               }
            
            //print an endline
             //Method: printEndline
            conIO.printEndline();            
         }
      
      /*
      name: charToInt
      process: turns character into an integer
      method input/parameters: number character (char)
      method output/parameters: none
      method output/returned: integer of the character (int)
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
     */
      public static int charToInt( char character )
         {
             return (int)( character - '0' );
         }

   }
