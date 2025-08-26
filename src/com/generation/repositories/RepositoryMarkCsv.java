package com.generation.repositories;

import com.generation.entities.Mark;
import com.generation.library.FileReader;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepositoryMarkCsv
{
	private ArrayList<Mark> content = new ArrayList<>();
	private String fileName;

	public RepositoryMarkCsv(String fileName)
	{
		this.fileName = fileName;

		FileReader reader = new FileReader(fileName);
		reader.readString();
		while (reader.hasRow())
			convertAndAddRow(reader.readString());
	}



	public void create(Mark r)
	{
		content.add(r);
		sync();
	}

	public void delete(Mark r)
	{
		content.remove(r);
		sync();
	}

	public void update(Mark newVersion,Mark oldVersion)
	{
		content.remove(oldVersion);
		content.add(newVersion);
		sync();
	}

	public ArrayList<Mark> read()
	{
		return content;
	}

	/**
	 * Questo metodo si occupa di convertire una SINGOLA RIGA del csv in un oggetto Mark e lo aggiunge alla lista
	 */
	private void convertAndAddRow(String row)
	{
		Mark r = new Mark();
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

		for(Mark r:content)
			builder.append("\n").append(convertMarkToRow(r));

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

	private String convertMarkToRow(Mark r)
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
