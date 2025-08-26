package com.generation.repositories;

import com.generation.entities.Mark;
import com.generation.entities.Student;
import com.generation.library.FileReader;

import java.io.FileWriter;
import java.util.ArrayList;

public class RepositoryStudentCsv
{
	private ArrayList<Student> content = new ArrayList<>();
	private String fileName;
	private RepositoryMarkCsv markRepo = new RepositoryMarkCsv("marks.csv");

	public RepositoryStudentCsv(String fileName)
	{
		this.fileName = fileName;

		FileReader reader = new FileReader(fileName);
		reader.readString();
		while (reader.hasRow())
			convertAndAddRow(reader.readString());

		for(Student s : content)
			for(Mark m: markRepo.read())
				if(m.getStudentId()==s.getId())
					s.addMark(m);
	}



	public void create(Student r)
	{
		content.add(r);
		sync();
	}

	public void delete(Student r)
	{
		content.remove(r);
		sync();
	}

	public void update(Student newVersion,Student oldVersion)
	{
		content.remove(oldVersion);
		content.add(newVersion);
		sync();
	}

	public ArrayList<Student> read()
	{
		return content;
	}

	/**
	 * Questo metodo si occupa di convertire una SINGOLA RIGA del csv in un oggetto Student e lo aggiunge alla lista
	 */
	private void convertAndAddRow(String row)
	{
		Student r = new Student();
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

		for(Student r:content)
			builder.append("\n").append(convertStudentToRow(r));

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

	private String convertStudentToRow(Student r)
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
