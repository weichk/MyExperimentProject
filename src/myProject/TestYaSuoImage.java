package myProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class TestYaSuoImage {
	
	public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = readPicturesToMemory();    
        //把内存中的图片写入到指定的文件中  
        String savePath = "D:/testImage/10-10/";
        
        File saveFile = new File(savePath);
		if (!saveFile.isDirectory())
			saveFile.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 4);
		factory.setRepository(saveFile);
		ServletFileUpload uploader = new ServletFileUpload(factory);
		uploader.setSizeMax(20 * 1024 * 1024);
		String saveFileName = savePath+"test.jpg";
        File fileOutPut = new File(saveFileName);  
        ImageIO.write(bufferedImage, "jpg", fileOutPut);
	}
	public static BufferedImage readPicturesToMemory()  
            throws IOException {   
        //Thumbnail读取水印文件到内存中  
        BufferedImage waterMarkBufferedImage = Thumbnails.of("D:\\testImage/test.4")  
                //Thumbnail的方法，根据比例缩小，0.4f意思是缩小到原图的40%  
                .size(20, 20)
                //读取成BufferedImage对象  
                .asBufferedImage();  
        return waterMarkBufferedImage;  
    }  
}
