
/**
 * Write a description of class negativeImageFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NegativeImageFilter implements  Filter
{
   public void filter(PixelImage theImage)
   {
       Pixel[][] data = theImage.getData();
       for(int row = 0; row < data.length; row++)
       {
           for(int col = 0; col < data[row].length; col++)
           {
               Pixel temp; 
               temp = data[row][col];
               Pixel n = new Pixel(255 - temp.getRed(), 255 - temp.getGreen(), 255 - temp.getBlue());
               data[row][col] = n;  
           }
       }
       theImage.setData(data);
   }
}
