package com.generation;

import com.generation.entities.Classroom;
import com.generation.entities.Student;
import com.generation.repositories.RepositoryClassroomCsv;

import java.util.*;

public class Prova {
	public static void main(String[] args) throws Exception {
		RepositoryClassroomCsv repo = new RepositoryClassroomCsv("classrooms.csv");

		// Carica tutte le classi
		List<Classroom> classrooms = repo.read();

		System.out.println("Classi caricate: " + classrooms.size());
		System.out.println("=====================================");

		// Per ogni classe richiama metodi sull'entità Classroom
		for (Classroom c : classrooms) {
			String header = "Classe " + c.getYear() + c.getSection();
			System.out.println(header);

			String sep = "";
			for (int i = 0; i < header.length(); i++) {
				sep = sep + "-";
			}
			System.out.println(sep);

			// Numero studenti
			System.out.println("Studenti: " + c.getStudents().size());

			// ==== METODI SU Classroom ====
			int numPromossi = c.numberPromoted();
			System.out.println("Promossi (numero): " + numPromossi);

			double percPromossi = c.percentagePromoted();
			System.out.println("Promossi (percentuale): " + percPromossi);

			System.out.println("");

			// ==== METODI SU Student (solo i primi 3) ====
			int counter = 0;
			for (Student s : c.getStudents()) {
				if (counter >= 3) {
					break;
				}
				System.out.println("Studente: " + s.getName() + " " + s.getSurname());

				double media = s.averageMark();
				System.out.println("Media voti: " + media);

				double percInsuff = s.failingPercentage();
				System.out.println("Insufficienze (percentuale): " + percInsuff);

				boolean promosso = s.isPromoted();
				System.out.println("Promosso: " + promosso);

				HashMap<String, Double> medieMateria = s.averagePerSubject();
				System.out.println("Medie per materia: " + medieMateria);

				System.out.println("");
				counter++;
			}

			System.out.println("");
		}
	}
}
