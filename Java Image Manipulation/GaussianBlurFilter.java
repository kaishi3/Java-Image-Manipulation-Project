public class GaussianBlurFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] copy = pi.getData();
        for (int row = 1; row < copy.length - 1; row++) {
            for (int col = 1; col < copy[row].length - 1; col++) {
                Pixel temp = copy[row][col];
                int weightedSumRed = ((4 * temp.getRed() + 2 * copy[row - 1][col].getRed() + 2 * copy[row + 1][col].getRed() + 2 * copy[row][col - 1].getRed() + 2 * copy[row][col+1].getRed() + copy[row+1][col+1].getRed() + copy[row+1][col-1].getRed() + copy[row-1][col-1].getRed() + copy[row-1][col+1].getRed())/16); 
                int weightedSumGreen = ((4 * temp.getGreen() + 2 * copy[row - 1][col].getGreen() + 2 * copy[row + 1][col].getGreen() + 2 * copy[row][col - 1].getGreen() + 2 * copy[row][col+1].getGreen() + copy[row+1][col+1].getGreen() + copy[row+1][col-1].getGreen() + copy[row-1][col-1].getGreen() + copy[row-1][col+1].getGreen())/16); 
                int weightedSumBlue = ((4 * temp.getBlue() + 2 * copy[row - 1][col].getBlue() + 2 * copy[row + 1][col].getBlue() + 2 * copy[row][col - 1].getBlue() + 2 * copy[row][col+1].getBlue() + copy[row+1][col+1].getBlue() + copy[row+1][col-1].getBlue() + copy[row-1][col-1].getBlue() + copy[row-1][col+1].getBlue())/16); 
                
                data[row][col] = new Pixel(weightedSumRed, weightedSumGreen, weightedSumBlue);
            }
        }
        pi.setData(data);
    }
}