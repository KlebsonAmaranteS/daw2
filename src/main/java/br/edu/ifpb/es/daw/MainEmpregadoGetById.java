package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EmpregadoDAO;
import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainEmpregadoGetById {
	public static void main(String[] args) throws DawException {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			EmpregadoDAO dao = new EmpregadoDAOImpl(emf);

			Empregado employee = new Empregado();

			employee.setNome("Klebson");
			employee.setSobrenome("Amarante");
			employee.setCpf("" + System.nanoTime());
			employee.setDataNascimento(LocalDate.of(2002, 06, 11));
			employee.setEndereco("Rua Caixa Bozo");
			employee.setSexo('M');
			employee.setSalario(new BigDecimal(1400.00));
			employee.setNdepedentes(0);

			dao.save(employee);

			Empregado result = dao.getByID(employee.getId());

			System.out.println(result);
		}
	}
}