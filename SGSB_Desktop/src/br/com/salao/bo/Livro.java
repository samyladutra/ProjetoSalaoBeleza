package br.com.salao.bo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {
	@Temporal(TemporalType.DATE)
	private Calendar publicacao;
	
	

}
