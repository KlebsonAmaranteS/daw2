package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EmpregadoDAO;
import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainEmpregadoSave {
	public static void main(String[] args) throws DawException {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			EmpregadoDAO dao = new EmpregadoDAOImpl(emf);

			Empregado employee = new Empregado();

			employee.setNome("João");
			employee.setSobrenome("Batista");
			employee.setCpf("" + System.nanoTime());
			employee.setDataNascimento(LocalDate.of(2003, 8, 16));
			employee.setEndereco("Rua da feira");
			employee.setSexo('M');
			employee.setSalario(new BigDecimal(1400.00));
			employee.setNdepedentes(2);

			System.out.println(employee);

			dao.save(employee);

			System.out.println(employee);
		}
	}
}