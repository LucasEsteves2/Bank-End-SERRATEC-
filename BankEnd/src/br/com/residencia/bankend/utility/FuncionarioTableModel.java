package br.com.residencia.bankend.utility;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.com.residencia.bankend.contas.Contas;

//Estava aprendendo a criar jtable e vi uns tutoriais recomendando criar o proprio model

public class FuncionarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Contas> dados = new ArrayList<>();
	private String[] colunas = { "ID", "Cliente", "Cpf", "    conta", "      agencia" };

	public ArrayList<Contas> getDados() {
		return dados;
	}

	public void setDados(ArrayList<Contas> dados) {
		this.dados = dados;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];

	}

	// Metodo retorna quantidade de linhas
	@Override
	public int getRowCount() {

		return dados.size();

	}

	// Metodo retorna quantidade de colunas
	@Override
	public int getColumnCount() {

		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {
		case 0:
			return dados.get(linha).getId(); // 1 Coluna

		case 1:
			return dados.get(linha).getCliente().getNome(); // 2 linha

		case 2:
			return dados.get(linha).getCliente().getCpf(); //

		case 3:
			return dados.get(linha).getNumero();
		case 4:
			return dados.get(linha).getAgencia();

		}

		return null;

	}

	public void adicionarLinha(Contas novaConta) {

		this.dados.add(novaConta);
		this.fireTableDataChanged(); // metodo que atualiza a tabela
	}

	
	/*
	public void removeLinha(int linha, String cpf, Connection con, JTable jTabelaPaciente) {

		QueryBd banco = new QueryBd(con);

		banco.deletarMedico(cpf, jTabelaPaciente);

		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);

		JOptionPane.showMessageDialog(null, "Medico removido do sistema!!", "Medico Excluido",
				JOptionPane.INFORMATION_MESSAGE);

	}
	*/

	/*
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {

		switch (coluna) {
		case 0:
			dados.get(linha).(Integer.parseInt((String) valor)); // 1 Coluna

		case 1:
			dados.get(linha).setNome((String) valor); // 2 linha
			break;
		case 2:
			dados.get(linha).setCpf((String) valor); //
			break;
		case 3:
			dados.get(linha).setEndereco((String) valor);
			break;
		case 4:
			dados.get(linha).setEmail((String) valor);
			break;
		}

		this.fireTableRowsUpdated(linha, linha);

	}
*/
	
	public void limpaTabela(int linha) {

		dados.removeAll(dados);
		this.fireTableRowsDeleted(linha, linha);

	}

}
