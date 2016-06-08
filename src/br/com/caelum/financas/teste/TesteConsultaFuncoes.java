package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		// TypedQuery<BigDecimal> query = manager
		// .createQuery("select sum(m.valor) from Movimentacao m " +
		// "where m.conta=:pConta and m.tipoMovimentacao=:pTipo",
		// BigDecimal.class);
		TypedQuery<Double> query = manager
				.createQuery(
						"select avg(m.valor) from Movimentacao m "
								+ "where m.conta=:pConta and m.tipoMovimentacao=:pTipo",
						Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		// BigDecimal valor = queryç.getSingleResult();
		// System.out.println("Valor total de saída: " + valor);
		Double media = query.getSingleResult();
		System.out.println("Valor médio de saída: " + media);

		/*
		 * for (Movimentacao m : movimentacoes) {
		 * System.out.println("\nDescricao ..: " + m.getDescricao());
		 * System.out.println("Valor ......: R$ " + m.getValor()); }
		 */
		manager.close();

	}

}
