package com.edn.fixSubtitle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleTempoExibicaoLegenda {
	
	public static void main(String[] args) {

		String nomeArquivo = "Fantastic.Beasts.and.Where.to.Find.Them.srt";
		String caminhoEntradaLegenda = "C:/areaLegendasParaProcessar/" + nomeArquivo;
		String caminhoSaidaLegenda = "C:/areaLegendasProcessadas/" + nomeArquivo;
		
		String conteudoLegenda = ManipulaArquivosUtil.recuperarArquivo(caminhoEntradaLegenda);
		String conteudoLegendaProcessado = processaLegenda(conteudoLegenda, -2);
		
		ManipulaArquivosUtil.gravarArquivo(conteudoLegendaProcessado, caminhoSaidaLegenda);
	}
	
	public static String processaLegenda(String legenda, int segundosDiferenca) {
		String regex = "\\d{2}:\\d{2}:\\d{2}";
		Matcher matcher = Pattern.compile(regex).matcher(legenda);
		
		while(matcher.find()) {
			String tempo = matcher.group();
			String novoTempo = DataLegenda.alterarSegundosLegenda(segundosDiferenca, tempo);
			legenda = legenda.replace(tempo, novoTempo);
		}
		
		return legenda;
	}

}
