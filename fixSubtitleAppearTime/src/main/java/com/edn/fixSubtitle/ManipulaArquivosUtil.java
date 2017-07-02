package com.edn.fixSubtitle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipulaArquivosUtil {
	
	public static String recuperarArquivo(String caminho) {
		
		String content = null;
		
		try {
			byte[] arquivo = Files.readAllBytes(Paths.get(caminho));
			content = new String(arquivo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	public static void gravarArquivo(String conteudo, String caminho) {
		byte[] conteudoEmBytes = conteudo.getBytes();
		Path path = Paths.get(caminho);
		
		try {
			Files.write(path, conteudoEmBytes);
			System.out.println("Arquivo gerado com sucesso !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
