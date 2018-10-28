package br.com.malabar.contemp;

import br.com.malabar.contemp.dao.OrcamentoDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		OrcamentoDao.getListOrcamento().stream().forEach(obj -> System.out.println(obj));
		
	}
}
