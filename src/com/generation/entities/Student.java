package com.generation.entities;

import java.util.HashMap;

/**
 * Uno studente ha come proprietà
 * name - surname - dob (data di nascita, local date, formato base yyyy-mm-dd)
 *
 * Classroom 1 - N studenti
 * Proprietà relazionale + pk/fk
 * qui vogliamo fk classroom + singola proprietà classroom
 *
 * Studente 1 - N Marks
 * Proprietà relazionale + pk/fk
 * qui vogliamo lista Marks
 */
public class Student
{
	/**
	 * TODO
	 * Come quello nei treni per aggiungere ticket a Route
	 * Ricordatevi anche di fare il setter di Student bene in Mark
	 */
	public void addMark(Mark m)
	{

	}

	/**
	 * TODO
	 * Deve restituire la media totale dei value dei voti
	 */
	public double averageMark()
	{
		return 0;
	}

	/**
	 * TODO
	 * Voglio sapere quante insufficienze ha in percentuale
	 * es: 10 voti di cui 2 insufficienti allora deve restituire 0.2
	 */
	public double failingPercentage()
	{
		return 0;
	}

	/**
	 * TODO
	 * Uno studente passa l'anno se ha media maggiore uguale di 7
	 * e meno del 0.15 di insufficienze
	 */
	public boolean isPromoted()
	{
		return true;
	}

	/**
	 * TODO
	 * PER ULTIMISSIMO MI RACCOMANDO
	 * Voglio che restituisca una mappa dove le chiavi sono i nomi
	 * delle materie e i valori la media per quella materia
	 */
	public HashMap<String,Double> averagePerSubject()
	{
		return null;
	}
}
