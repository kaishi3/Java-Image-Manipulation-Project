public class FlipVerticalFilter implements Filter
{
   public void filter(PixelImage pi) {
       Pixel[][] data = pi.getData();    
       
       /* for (int col = 0; col < data[col].length ; col++) {
            for (int row = 0; row < data.length / 2; row++) {
                //Pixel temp = data[row][col];
               // data[row][col] = data[row][ data[row].length - col - 1 ];
                //data[row][ data[row].length - col - 1 ] = temp;
                Pixel temp = data[row][col];
                data[row][col] = data[col][data[col].length - row - 1];
                data[data.length - row - 1][col] = temp;
            }
       } */       
       int rows = data.length; 
       Pixel[] temp;
       for(int i = 0; i< rows/2; i++)
       {
         temp = data[rows - i - 1];
         data[rows - i - 1] = data[i];
         data[i] = temp;
       }
       pi.setData(data);
    }
}
