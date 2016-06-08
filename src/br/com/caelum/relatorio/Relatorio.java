package br.com.caelum.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.financas.util.ConexaoDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class Relatorio {

	public static void main(String[] args) {
//		try {
//			JasperCompileManager.compileReportToFile("report4.jrxml");
//			JasperCompileManager.compileReportToFile("report4_subreport1.jrxml");
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Map<String, Object> parametros = new HashMap<String, Object>();
		Connection connexao = ConexaoDAO.abreConexao();

		JasperPrint print;
		try {
			print = JasperFillManager.fillReport("report4_subreport1.jasper", parametros, connexao);
			JRExporter exporter = new JRHtmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("report5.html"));
			exporter.exportReport();

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexaoDAO.fechaConexao(connexao);
	}

}
