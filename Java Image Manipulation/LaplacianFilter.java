public class LaplacianFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] copy = pi.getData();
        for (int row = 1; row < copy.length - 1; row++) {
            for (int col = 1; col < copy[row].length - 1; col++) {
                Pixel temp = copy[row][col];
                int weightedSumRed = ((8 * temp.getRed() - copy[row - 1][col].getRed() - copy[row + 1][col].getRed() - copy[row][col - 1].getRed() - copy[row][col+1].getRed() - copy[row+1][col+1].getRed() - copy[row+1][col-1].getRed() - copy[row-1][col-1].getRed() - copy[row-1][col+1].getRed())); 
                int weightedSumGreen = ((8 * temp.getGreen() - copy[row - 1][col].getGreen() - copy[row + 1][col].getGreen() - copy[row][col - 1].getGreen() - copy[row][col+1].getGreen() - copy[row+1][col+1].getGreen() - copy[row+1][col-1].getGreen() - copy[row-1][col-1].getGreen() - copy[row-1][col+1].getGreen())); 
                int weightedSumBlue = ((8 * temp.getBlue() - copy[row - 1][col].getBlue() - copy[row + 1][col].getBlue() - copy[row][col - 1].getBlue() - copy[row][col+1].getBlue() - copy[row+1][col+1].getBlue() - copy[row+1][col-1].getBlue() - copy[row-1][col-1].getBlue() - copy[row-1][col+1].getBlue())); 
                if(weightedSumRed < 0)
                    weightedSumRed = 0;
                if(weightedSumGreen < 0)
                    weightedSumGreen = 0;
                if(weightedSumBlue < 0)
                    weightedSumBlue = 0;
                if(weightedSumRed > 255)
                    weightedSumRed = 255;
                if(weightedSumGreen > 255)
                    weightedSumGreen = 255;
                if(weightedSumBlue > 255)
                    weightedSumBlue = 255;
                data[row][col] = new Pixel(weightedSumRed, weightedSumGreen, weightedSumBlue);
            }
        }
        pi.setData(data);
    }
}