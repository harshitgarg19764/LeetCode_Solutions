class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five =0;
        int ten =0;
        int tewenty =0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five<1){
                    return false;
                }
                else{
                    five--;
                    ten++;
                }
            }
            else if(bills[i]==20){
                if(ten>=1 && five>=1){
                    five-=1;
                    ten-=1;
                    tewenty++;
                }
                else if(five>=3){
                    five-=3;
                    tewenty++;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}