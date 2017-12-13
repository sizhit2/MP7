
import java.util.Arrays;

public class encryption {
    private String afterEncrypt;
    public String getAfterEncrypt() {
    	    return afterEncrypt;
    }
    private String afterDecrypt;
    public String getAfterDecrypt() {
    		return afterDecrypt;
    }
    // create encryption array, which is used to store all the encryption instance we create
    public static encryption[] encryptList = new encryption[100];
    private static int encryptionIndex = 0;
    
    
    
    
    public static char[] Convetor (final String userTextInput, final String cs){
    	char[] TextInput= new char[userTextInput.length()];
    	//check if the userPassword is valid
    /*	if (cs.length < 6) {
    		System.out.println("The password you entered is invalid.");
    		// set warning window...
    	} else*/ if (userTextInput != "") {
			for(int i = 0; i < TextInput.length; i++) {
				TextInput[i] = userTextInput.charAt(i);
			}
			return TextInput;
		} else {
			System.out.println("The Text Input is Invalid to Encode!");
			return null;		
			}
     	
    }
    
    private static int[] store (final char[] TextInput) {
    	
    int[] store = new int[4];
    int textLength = TextInput.length;
    int randomSliceIndex = (int)(textLength * Math.random());
    store[0] = randomSliceIndex;
    String[] conversion = {"binary","octal","decimal","hexadecimal"};
    // use index to record the ary-ary, random number generates index
    int slice1Conv = (int)(Math.random() * conversion.length);//
    int slice2Conv = (int)(Math.random() * conversion.length);//
    store[1] = slice1Conv;
    store[2] = slice2Conv;
    char[] slice1 = Arrays.copyOfRange(TextInput,0,randomSliceIndex);
    int[] intSlice1 = new int[slice1.length];
    String[] s1After = aryConversion(intSlice1, slice1Conv);//
    store[3] = s1After.length;
    	return store;
    }
    static String[] concat(String[] a, String[] b) {  
    	   String[] c= new String[a.length+b.length];  
    	   System.arraycopy(a, 0, c, 0, a.length);  
    	   System.arraycopy(b, 0, c, a.length, b.length);  
    	   return c;  
    	}  
    
    private static String[] doEncrypt(final char[] TextInput,final int[] store){
       
        //store the password user entered and text entered
        // this.passwordStore = userPassword;
           // this.encryptedText = TextInput;
        
         int randomSliceIndex = store[0];
        char[] slice1 = Arrays.copyOfRange(TextInput,0,randomSliceIndex);
        char[] slice2 = Arrays.copyOfRange(TextInput,randomSliceIndex,TextInput.length);
        int[] intSlice1 = new int[slice1.length];
        int[] intSlice2 = new int[slice2.length];
        
        		
        for (int i = 0; i < slice1.length; i++) {
        		intSlice1[i] = (int)(slice1[i]);
        }
        for (int i = 0; i < slice2.length; i++) {
    		intSlice2[i] = (int)(slice2[i]);
        }
        
        int slice1Conv =store[1];
        int slice2Conv =store[2];
        String[] s1After = aryConversion(intSlice1, slice1Conv);//
        String[] s2After = aryConversion(intSlice2, slice2Conv);//
        String[] result = concat(s1After, s2After);
        return result;
        
        }
    
        private static char[] doDecrypt (final String[] EncryptedText, final int[] store){
        
        // generate random number to slice the text in half
    	    String[] slice1 = Arrays.copyOfRange(EncryptedText, 0, store[0]);
    	    String[] slice2 = Arrays.copyOfRange(EncryptedText, store[0], EncryptedText.length);
    	    
    	    int indicator1 = store[1];
    	    int indicator2 = store[2];
        		
    	    String[] decryptedText1 = decryptedText(slice1, indicator1);
    	    String[] decryptedText2 = decryptedText(slice2, indicator2);
    	    
    	    String[] result = concat(decryptedText1, decryptedText2);
    	    char[] output = new char[result.length];
    	    
    	    for (int i = 0; i < result.length; i++) {
    	    	   int a = Integer.parseInt(result[i]);
    	    	   char x = (char)a;
    	    	   output[i] = x;
    	    	   
    	    }
    	    
        return output;

        }
        
    
    private static String[] aryConversion(int[] intSlice,int indexOfConversion){
	    String[] s = new String[intSlice.length];
	    
        if(indexOfConversion == 0){

        	    for(int i= 0; i < intSlice.length; i++) {
        	      	s[i] = Integer.toBinaryString(intSlice[i]);
        	    }
        	    
        	    return s;
            //return Integer.toBinaryString(intSlice);
        } else if (indexOfConversion == 1){
    
    	    for(int i= 0; i < intSlice.length; i++) {
    	      	s[i] = Integer.toOctalString(intSlice[i]);
    	    }
    	    return s;
            //return Integer.toOctalString(intSlice);
        } else if (indexOfConversion == 2){
   
    	    for(int i= 0; i < intSlice.length; i++) {
    	      	s[i]= Integer(intSlice[i]).toString();
    	    }
    	    return s;
           // return Integer(intSlice).toString();
        } else if (indexOfConversion == 3){

    	    for(int i= 0; i < intSlice.length; i++) {
    	      	s[i] = Integer.toHexString(intSlice[i]);
    	    }
    	    return s;
           // return Integer.toHexString(intSlice);
        }
        return s;
    }
    
    private static String[] decryptedText (String[] slice, int indicator) {
    	   String[] result = new String[slice.length];
    	   if (indicator == 0) {
    		   for (int i = 0; i < slice.length; i++) {
    			   result[i] = Integer.valueOf(slice[i], 2).toString();  
    		   }
    			return result;
    	   } else if (indicator == 1) {
    		   for (int i = 0; i < slice.length; i++) {
    			   result[i] = Integer.valueOf(slice[i], 8).toString();  
    		   }
    			return result;
    	   } else if (indicator == 2) {
    		   for (int i = 0; i < slice.length; i++) {
    			   result[i] = slice[i];  
    		   }
    			return result;
    	   } else if (indicator == 3) {
    		   for (int i = 0; i < slice.length; i++) {
    			   result[i] = Integer.valueOf(slice[i], 16).toString();  
    		   }
    			return result;
    	   }
    		return result;
    }
    private static Object Integer(int intSlice) {
		// TODO Auto-generated method stub
		return intSlice;
	}
    public encryption(final String userTextInput,final String password) {
    		char[] first = Convetor(userTextInput, password);
    		int[] store = store(first);
    		String[] encryptedText = doEncrypt(first, store);
    		afterEncrypt = "";
    		for(int i = 0; i < encryptedText.length;i++) {
    			afterEncrypt += encryptedText[i];
    		}
    		encryptList[encryptionIndex] = this;
    		encryptionIndex ++;
    		 char[] decryptedText = encryption.doDecrypt(encryptedText, store);
    		 afterDecrypt = "";
    	       for (int i = 0; i < decryptedText.length; i++) {
    		       afterDecrypt += decryptedText[i];
    	   }    
    		
    		
    }
	public static void main(String[] args){
		encryption test = new encryption("I love Pizza", "123456");
		System.out.println(test.getAfterEncrypt());
		System.out.println(test.getAfterDecrypt());
		System.out.println(encryptList[0].getAfterEncrypt());
		System.out.println(encryptList[0].getAfterDecrypt());
		/*
       char[] first = encryption.Convetor(" I Love Pizza ", "123456");
       int[] store = encryption.store(first);
       for (int i = 0; i < store.length; i++) {
    	       System.out.println(store[i]);
    	       
       }
       String[] encryptedText = encryption.doEncrypt(first, store);
       System.out.println();
       for (int i = 0; i < encryptedText.length; i++) {
    	       System.out.print(encryptedText[i]);
    	   
       }
       
      
       char[] decryptedText = encryption.doDecrypt(encryptedText, store);
       System.out.println();
       for (int i = 0; i < decryptedText.length; i++) {
	       System.out.print(decryptedText[i]);
	       }  
       System.out.println(encryptList[0]);*/
    }

}
