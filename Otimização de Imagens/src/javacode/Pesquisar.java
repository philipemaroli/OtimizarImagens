/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.io.IOException; 
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class Pesquisar{

  public void Pesquisar(String campo, String salvar) throws IOException{
    
    System.out.println(salvar);
    System.out.println(campo);  
      
    File file = new File(campo); 
           
    int count = file.listFiles().length;  
    String[] arquivos = new String[count]; 
    
        File ler = new File(campo);
        File[] diretorio = ler.listFiles();
        
        for(int k=0;k<count; k++){
            arquivos[k] = diretorio[k].getName();  
        }
        
       double aux = 1;
       double b;
       
        for(int j=0; j < count;j++){ 
            String nomeCompletoDoArquivo = (campo+"/"+arquivos[j]);
            String extensaoDoArquivo = getFileExtension(nomeCompletoDoArquivo);
            b = (100*aux)/count;
            System.out.printf("\n%.0f%%", b);
            
            aux++;
                if(extensaoDoArquivo.equals("JPG") || extensaoDoArquivo.equals("jpg")){

                    File input = new File(""+diretorio[j]);
                    BufferedImage image = ImageIO.read(input);

                    File compressedImageFile = new File(""+salvar+"/"+arquivos[j]);
                    OutputStream os = new FileOutputStream(compressedImageFile);

                    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
                    ImageWriter writer = (ImageWriter) writers.next();

                    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                    writer.setOutput(ios);

                    ImageWriteParam param = writer.getDefaultWriteParam();

                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    param.setCompressionQuality(0.5f);  // Change the quality value you prefer
                    writer.write(null, new IIOImage(image, null, null), param);

                    os.close();
                    ios.close();
                    writer.dispose();
                    
                    if(!campo.equals(salvar)){
                        File delete = new File(campo+"/"+arquivos[j]); 
                        delete.delete();
                    }
                        
                }
                
                
        }
    }
    
    static String getFileExtension(String filename) {
        if (filename.contains("."))
            return filename.substring(filename.lastIndexOf(".") + 1);
        else
            return "";
    }

    
    
    
    
  } 
  
 




