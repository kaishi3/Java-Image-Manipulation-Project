public class GreyScaleFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Pixel temp = data[row][col];
                int average = (temp.getRed() + temp.getGreen() + temp.getBlue()) / 3;
                data[row][col] = new Pixel(average, average, average);
            }
        }
        pi.setData(data);
    }
}
