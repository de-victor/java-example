package br.com.malabar.contemp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.malabar.contemp.conn.ConnectionAdp;
import br.com.malabar.contemp.model.OrcamentoModel;
import lombok.extern.java.Log;

@Log
public class OrcamentoDao {

	public static List<OrcamentoModel> getListOrcamento() throws Exception {
		String query = "select exercico, cod_orgao_sup from transparencia2.tbf_orcamento";
		ConnectionAdp connectionAdp = new ConnectionAdp();

		ResultSet result = connectionAdp.query(query);

		List<OrcamentoModel> listaOrcamento = new ArrayList<OrcamentoModel>();

		try {
			while (result.next()) {
				listaOrcamento.add(new OrcamentoModel(result.getInt("exercico"), result.getInt("cod_orgao_sup")));
			}
		} catch (Exception e) {
			log.severe("Erro ao executar query: " + e);
		} finally {
			connectionAdp.close();
		}

		return listaOrcamento;
	}

}
