package com.edn.fixSubtitle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleTempoExibicaoLegenda {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("##############################################################");
		System.out.println("##############################################################");
		System.out.println("##############################################################");		
		System.out.println("O arquivo de estar na pasta C:/Downloads/subtitles");
		System.out.println("Ele será ajustado de acordo com o valor passado");
		System.out.println("##############################################################");
		System.out.println("##############################################################");
		System.out.println("##############################################################");
		System.out.println();
		System.out.println("Informe o nome completo do arquivo (com a extensão)");
		String nomeArquivo = sc.next();
		System.out.println("Infome os segundos que deseja ajustar a legenda. Obs: aceita valores negativos, exp: -1");
		int segundos = sc.nextInt();
		String legenda = "C:/Downloads/subtitles/" + nomeArquivo;
		
		if(isFileValid(legenda)) {		
			String conteudoLegenda = ManipulaArquivosUtil.recuperarArquivo(legenda);
			String conteudoLegendaProcessado = processaLegenda(conteudoLegenda, segundos);
			String caminhoSaida = "C:/Downloads/subtitles/fixed/";
			ManipulaArquivosUtil.gravarArquivo(conteudoLegendaProcessado, caminhoSaida, nomeArquivo);
						
		}else {
			System.out.println("Arquivo invalido ou nao copiado para a pasta c:/Downloads/subtitles/");
			
		}
		
		sc.close();
	}
	
	public static String processaLegenda(String legenda, int segundosDiferenca) {
		String regex = "\\d{2}:\\d{2}:\\d{2},\\d{3}";
		Matcher matcher = Pattern.compile(regex).matcher(legenda);
		
		while(matcher.find()) {
			String tempo = matcher.group();
			
			String[] token = tempo.split(",");
			
			String novoTempo = DataLegenda.alterarSegundosLegenda(segundosDiferenca, token[0]);
			legenda = legenda.replace(tempo, novoTempo + "," + token[1]);
		}
		
		return legenda;
	}

	private static boolean isFileValid(String file) {
		if(!file.contains(".srt")) return false;

		Path path = Paths.get(file);		
		if(Files.notExists(path)) return false;
				
		return true;
	}
	
}
