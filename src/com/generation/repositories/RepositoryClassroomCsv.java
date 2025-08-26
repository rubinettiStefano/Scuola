package com.generation.repositories;

import com.generation.entities.Mark;
import com.generation.entities.Classroom;
import com.generation.entities.Student;
import com.generation.library.FileReader;

import java.io.FileWriter;
import java.util.ArrayList;

public class RepositoryClassroomCsv
{
	private ArrayList<Classroom> content = new ArrayList<>();
	private String fileName;
	private RepositoryStudentCsv studentRepo = new RepositoryStudentCsv("students.csv");

	public RepositoryClassroomCsv(String fileName)
	{
		this.fileName = fileName;

		FileReader reader = new FileReader(fileName);
		reader.readString();
		while (reader.hasRow())
			convertAndAddRow(reader.readString());

		for(Classroom c : content)
			for(Student s: studentRepo.read())
				if(s.getClassroomId()==c.getId())
					c.addStudent(s);
	}



	public void create(Classroom r)
	{
		content.add(r);
		sync();
	}

	public void delete(Classroom r)
	{
		content.remove(r);
		sync();
	}

	public void update(Classroom newVersion,Classroom oldVersion)
	{
		content.remove(oldVersion);
		content.add(newVersion);
		sync();
	}

	public ArrayList<Classroom> read()
	{
		return content;
	}

	/**
	 * Questo metodo si occupa di convertire una SINGOLA RIGA del csv in un oggetto Classroom e lo aggiunge alla lista
	 */
	private void convertAndAddRow(String row)
	{
		Classroom r = new Classroom();
		String[] spl = row.split(",");
		//TODO riempimento dell'oggetto con array splittato
//		r.setId(Long.parseLong(spl[0])); // nuovo campo id
//		r.setCustomerFullName(spl[1]);
//		r.setSeat(spl[2]);
//		r.setObliterated(Boolean.parseBoolean(spl[3]));
//		r.setDiscountPercentage(Integer.parseInt(spl[4]));
//		r.setDay(LocalDate.parse(spl[5]));
//		r.setRouteId(Long.parseLong(spl[6]));
		content.add(r);
	}

	private void sync()
	{
		StringBuilder builder = new StringBuilder();
		//todo intestazione
//		builder.append("id,customerFullName,seat,obliterated,discountPercentage,day,routeId");

		for(Classroom r:content)
			builder.append("\n").append(convertClassroomToRow(r));

		try
		{
			FileWriter writer = new FileWriter(fileName);
			writer.write(builder.toString());
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("SOVRASCRITTURA FALLITA");
		}
	}

	private String convertClassroomToRow(Classroom r)
	{
		StringBuilder builder = new StringBuilder();
		//TODO creazione riga csv
//		builder.append(r.getId()).append(",");
//		builder.append(r.getCustomerFullName()).append(",");
//		builder.append(r.getSeat()).append(",");
//		builder.append(r.isObliterated()).append(",");
//		builder.append(r.getDiscountPercentage()).append(",");
//		builder.append(r.getDay()).append(",");
//		builder.append(r.getRouteId()).append(",");
		return builder.toString();
	}
}
