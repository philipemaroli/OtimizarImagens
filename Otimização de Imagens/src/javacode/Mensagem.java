/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import static javacode.Pesquisar.getFileExtension;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JTextField;

/**
 *
 * @author estagiario
 */
public class Mensagem {
    public static boolean Mensagem_Final(String campo, String salvar){
        
        File file = new File(campo); 
           
        int count = file.listFiles().length;  
        String[] arquivos = new String[count]; 
    
        File ler = new File(campo);
        File[] diretorio = ler.listFiles();
        
        for(int k=0;k<count; k++){
            arquivos[k] = diretorio[k].getName();  
        }
        
        int countJPG=0;
        
        for(int j=0; j < count;j++){ 
            String nomeCompletoDoArquivo = (campo+"/"+arquivos[j]);
            String extensaoDoArquivo = getFileExtension(nomeCompletoDoArquivo);
                if(extensaoDoArquivo.equals("JPG") || extensaoDoArquivo.equals("jpg")){
                      countJPG++;
                        
                }       
        }
  
        if(countJPG==0){             
            return true;            
        }else{
            return false;
        }
    }
}
