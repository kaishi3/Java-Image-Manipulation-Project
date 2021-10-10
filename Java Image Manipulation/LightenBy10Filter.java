
/**
 * Write a description of class f here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightenBy10Filter implements Filter 
{
     public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
               Pixel temp; 
               temp = data[row][col];
               int lighterRed = temp.getRed();
               int lighterGreen = temp.getGreen();
               int lighterBlue = temp.getBlue(); 
               if(temp.getRed() <= 230)
                 lighterRed = temp.getRed() + 25;
               if(temp.getGreen() <= 230)
                 lighterGreen = temp.getGreen() + 25;  
               if(temp.getBlue() <= 230)
                 lighterBlue = temp.getBlue() + 25;
               Pixel n = new Pixel(lighterRed , lighterGreen , lighterBlue);
               data[row][col] = n;  
            }
        }
        pi.setData(data);
    }
}
