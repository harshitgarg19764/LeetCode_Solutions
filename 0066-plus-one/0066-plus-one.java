class Solution {
    public int[] plusOne(int[] digits) {
        // long num =0;
        // for(int i=0;i<digits.length;i++){
        //     num = num*10 + digits[i];
        // }
        // num = num + 1;
        // System.out.println(num);
        // System.out.println((int)Math.log10(num)+1);

        // int arr[] = new int[(int)Math.log10(num)+1];
        // int i=arr.length-1;
        // while(num>0){
        //     long digit = num%10;
        //     arr[i] = (int)digit;
        //     num = num/10;
        //     i--;
        // }
        // return arr;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
            int arr[] = new int[digits.length+1];
            arr[0] = 1;
            return arr;

    }
}